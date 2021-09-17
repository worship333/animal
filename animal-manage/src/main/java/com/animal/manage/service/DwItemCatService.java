package com.animal.manage.service;

import java.util.List;

import com.animal.commons.pojo.EasyUiTree;

public interface DwItemCatService {
	/**
	 * 根据父菜单id显示所有子菜单
	 * @param pid
	 * @return
	 */
	List<EasyUiTree> show(long pid);
}
