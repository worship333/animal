package com.animal.dubbo.service;

import com.animal.pojo.DwUser;

public interface DwUserDubboService {
	/**
	 * 根据用户名和密码查询登录
	 * @param user
	 * @return
	 */
	DwUser selByUser(DwUser user);
}
