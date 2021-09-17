package com.animal.passport.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.commons.pojo.AnimalResult;
import com.animal.passport.service.DwUserService;
import com.animal.pojo.DwUser;





@Controller
public class DwUserController {
	@Resource
	private DwUserService dwUserServiceImpl;
	/**
	 * 显示登录页面
	 * @return
	 */
	@RequestMapping("user/showLogin")
	public String showLogin(@RequestHeader(value="Referer",defaultValue="") String url,Model model,String interurl){
		if(interurl!=null&&!interurl.equals("")){
			model.addAttribute("redirect", interurl);
		}else if(!url.equals("")){
			model.addAttribute("redirect", url);
		}
		return "login";
	}
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping("user/login")
	@ResponseBody
	public AnimalResult login(DwUser user,HttpServletRequest request,HttpServletResponse response){
		return dwUserServiceImpl.login(user,request,response);
	}
	/**
	 * 通过token获取用户信息
	 * @param token
	 * @param callback
	 * @return
	 */
	@RequestMapping("user/token/{token}")
	@ResponseBody
	public Object getUserInfo(@PathVariable String token,String callback){
		AnimalResult er = dwUserServiceImpl.getUserInfoByToken(token);
		if(callback!=null&&!callback.equals("")){
			MappingJacksonValue mjv = new MappingJacksonValue(er);
			mjv.setJsonpFunction(callback);
			return mjv;
		}
		return er;
	}
	/**
	 * 退出
	 * @param token
	 * @param callback
	 * @return
	 */
	@RequestMapping("user/logout/{token}")
	@ResponseBody
	public Object logout(@PathVariable String token,String callback,HttpServletRequest request,HttpServletResponse response){
		AnimalResult er = dwUserServiceImpl.logout(token,request,response);
		if(callback!=null&&!callback.equals("")){
			MappingJacksonValue mjv = new MappingJacksonValue(er);
			mjv.setJsonpFunction(callback);
			return mjv;
		}
		return er;
	}
}
