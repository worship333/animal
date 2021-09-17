package com.animal.passport.service.impl;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.utils.CookieUtils;
import com.animal.commons.utils.JsonUtils;
import com.animal.dubbo.service.DwUserDubboService;
import com.animal.passport.service.DwUserService;
import com.animal.pojo.DwUser;
import com.animal.redis.dao.JedisDao;


@Service
public class DwUserServiceImpl implements DwUserService {
	@Reference
	private DwUserDubboService dwUserDubboServiceImpl;
	@Resource
	private JedisDao jedisDaoImpl;
	@Override
	public AnimalResult login(DwUser user,HttpServletRequest request,HttpServletResponse response) {
		AnimalResult er = new AnimalResult();
		DwUser userSelect = dwUserDubboServiceImpl.selByUser(user);
		if(userSelect!=null){
			er.setStatus(200);
			//当用户登录成功后把用户信息放入到redis中
			String key = UUID.randomUUID().toString();
			jedisDaoImpl.set(key, JsonUtils.objectToJson(userSelect));
			//有效时间是一周
			jedisDaoImpl.expire(key, 60*60*24*7);
			//产生Cookie
			CookieUtils.setCookie(request, response, "TT_TOKEN", key, 60*60*24*7);
		}else{
			er.setMsg("用户名和密码错误");
		}
		return er;
	}
	
	@Override
	public AnimalResult getUserInfoByToken(String token) {
		AnimalResult er = new AnimalResult();
		String json = jedisDaoImpl.get(token);
		if(json!=null&&!json.equals("")){
			DwUser dwUser = JsonUtils.jsonToPojo(json, DwUser.class);
			//可以把密码清空
			dwUser.setPassword(null);
			er.setStatus(200);
			er.setMsg("OK");
			er.setData(dwUser);
		}else{
			er.setMsg("获取失败");
		}
		
		return er;
	}
	
	@Override
	public AnimalResult logout(String token, HttpServletRequest request, HttpServletResponse response) {
		Long index = jedisDaoImpl.del(token);
		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		AnimalResult er = new AnimalResult();
		er.setStatus(200);
		er.setMsg("OK");
		return er;
	}

}
