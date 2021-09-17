package com.animal.dubbo.service;

import java.util.List;

import com.animal.pojo.DwContentCategory;

public interface DwContentCategoryDubboService {
	/**
	 * 根据父id查询所有子类目
	 * @param id
	 * @return
	 */
	List<DwContentCategory> selByPid(long id);
	/**
	 * 新增
	 * @param cate
	 * @return
	 */
	int insDwContentCategory(DwContentCategory cate);
	/**
	 * 修改isparent通过id
	 * @param id
	 * @param isParent
	 * @return
	 */
	int updIsParentById(DwContentCategory cate);
	
	
	/**
	 * 通过id查询内容类目详细信息
	 */
	DwContentCategory selById(long id);
}
