package com.animal.dubbo.service;

import java.util.List;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.pojo.DwItem;
import com.animal.pojo.DwItemDesc;

public interface DwItemDubboService {
	/**
	 * 动物分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	
	/**
	 * 根据id修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	int updItemStatus(DwItem dwItem);
	
	/**
	 * 商品新增
	 * @param dwItem
	 * @return
	 */
	int insDwItem(DwItem dwItem);
	
	/**
	 * 新增包含商品表和商品描述表
	 * @param dwItem
	 * @param desc
	 * @return
	 */
	int insDwItemDesc(DwItem DwItem,DwItemDesc desc)  throws Exception;
	
	/**
	 * 通过状态查询全部可用数据
	 * @return
	 */
	List<DwItem> selAllByStatus(byte status);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	DwItem selById(long id);
}
