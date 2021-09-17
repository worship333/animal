package com.animal.dubbo.service;

import com.animal.pojo.DwItemDesc;

public interface DwItemDescDubboService {
	/**
	 * 新增
	 * @param itemDesc
	 * @return
	 */
	int insDesc(DwItemDesc itemDesc);
	/**
	 * 根据主键查询商品描述对象
	 * @param itemid
	 * @return
	 */
	DwItemDesc selByItemid(long itemid);
}
