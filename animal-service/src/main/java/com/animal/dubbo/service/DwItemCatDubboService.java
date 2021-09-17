package com.animal.dubbo.service;

import java.util.List;

import com.animal.pojo.DwItemCat;

public interface DwItemCatDubboService {
	/**
	 * 根据父类目id查询所有子类目
	 * @param pid
	 * @return
	 */
	List<DwItemCat> show(long pid);
	/**
	 * 根据类目id查询
	 * @param id
	 * @return
	 */
	DwItemCat selById(long id);
}
