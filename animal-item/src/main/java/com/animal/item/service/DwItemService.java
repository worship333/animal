package com.animal.item.service;

import com.animal.commons.pojo.DwItemChild;

public interface DwItemService {
	/**
	 * 显示商品详情
	 * @param id
	 * @return
	 */
	DwItemChild show(long id);
}
