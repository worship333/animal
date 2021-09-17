package com.animal.passport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.commons.pojo.AnimalResult;
import com.animal.pojo.DwUser;



public interface DwUserService {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	AnimalResult login(DwUser user,HttpServletRequest request,HttpServletResponse response);
	/**
	 * 根据token查询用户信息
	 * @param token
	 * @return
	 */
	AnimalResult getUserInfoByToken(String token);
	
	/**
	 * 退出
	 * @param token
	 * @param request
	 * @param response
	 * @return
	 */
	AnimalResult logout(String token,HttpServletRequest request,HttpServletResponse response);
}
