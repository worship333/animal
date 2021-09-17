package com.animal.manage.service;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.pojo.DwContent;

public interface DwContentService {
	/**
	 * 分页显示内容信息
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showContent(long categoryId,int page,int rows);
	/**
	 * 新增内容
	 * @param content
	 * @return
	 */
	int save(DwContent content);
}
