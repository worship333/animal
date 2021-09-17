package com.animal.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.EasyUiTree;
import com.animal.manage.service.DwContentCategoryService;
import com.animal.pojo.DwContentCategory;


@Controller
public class DwContentCategoryController {
	@Resource
	private DwContentCategoryService dwContentCategoryServiceImpl;
	/**
	 * 查询动物类目
	 * @param id
	 * @return
	 */
	@RequestMapping("content/category/list")
	@ResponseBody
	public List<EasyUiTree> showCategory(@RequestParam(defaultValue="0") long id){
		return dwContentCategoryServiceImpl.showCategory(id);
	}
	/**
	 * 新增内容类目
	 * @param cate
	 * @return
	 */
	@RequestMapping("content/category/create")
	@ResponseBody
	public AnimalResult create(DwContentCategory cate){
		return dwContentCategoryServiceImpl.create(cate);
	}
	/**
	 * 重命名
	 * @param cate
	 * @return
	 */
	@RequestMapping("content/category/update")
	@ResponseBody
	public AnimalResult update(DwContentCategory cate){
		return dwContentCategoryServiceImpl.update(cate);
	}
	
	/**
	 * 删除
	 * @param cate
	 * @return
	 */
	@RequestMapping("content/category/delete")
	@ResponseBody
	public AnimalResult delete(DwContentCategory cate){
		return dwContentCategoryServiceImpl.delete(cate);
	}
}
