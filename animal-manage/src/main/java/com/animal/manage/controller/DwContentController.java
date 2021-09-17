package com.animal.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.manage.service.DwContentService;
import com.animal.pojo.DwContent;



@Controller
public class DwContentController {
	@Resource
	private DwContentService dwContentServiceImpl;
	
	/**
	 * 显示内容信息
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("content/query/list")
	@ResponseBody
	public EasyUIDataGrid showContent(long categoryId,int page,int rows){
		return dwContentServiceImpl.showContent(categoryId, page, rows);
	}
	/**
	 * 新增内容
	 * @param content
	 * @return
	 */
	@RequestMapping("content/save")
	@ResponseBody
	public AnimalResult save(DwContent content){
		AnimalResult er = new AnimalResult();
		int index = dwContentServiceImpl.save(content);
		if(index>0){
			er.setStatus(200);
		}
		return er;
	}
}
