package com.animal.dubbo.service;

import java.util.List;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.pojo.DwContent;


public interface DwContentDubboService {
	/**
	 * 分页查询
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid selContentByPage(long categoryId,int page,int rows);
	/**
	 * 新增
	 * @param content
	 * @return
	 */
	int insContent(DwContent content);
	
	/**
	 * 查询出最近的前n个
	 * @param count
	 * @return
	 */
	List<DwContent> selByCount(int count,boolean isSort);
}
