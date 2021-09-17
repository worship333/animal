package com.animal.manage.service;

import java.util.List;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.EasyUiTree;
import com.animal.pojo.DwContentCategory;

public interface DwContentCategoryService {
	/**
	 * 查询所有类目并转换为easyui tree的属性要求
	 * @return
	 */
	List<EasyUiTree> showCategory(long id);
	
	/**
	 * 类目新增
	 * @return
	 */
	AnimalResult create(DwContentCategory cate);
	
	/**
	 * 类目重命名
	 * @param cate
	 * @return
	 */
	AnimalResult update(DwContentCategory cate);
	/**
	 * 删除类目
	 * @param id
	 * @return
	 */
	AnimalResult delete(DwContentCategory cate);
}
