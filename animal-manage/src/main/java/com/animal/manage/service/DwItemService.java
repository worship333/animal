package com.animal.manage.service;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.pojo.DwItem;

public interface DwItemService {
	/**
	 * 显示动物
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	
	/**
	 * 批量修改商品状态
	 * @param ids
	 * @param status
	 * @return
	 */
	int update(String ids,byte status);
	
	/**
	 * 商品新增
	 * @param item
	 * @param desc
	 * @return
	 */
	int save(DwItem item ,String desc) throws Exception;
	
}
