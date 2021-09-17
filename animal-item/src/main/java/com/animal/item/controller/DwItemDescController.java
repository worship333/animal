package com.animal.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.item.service.DwItemDescService;


@Controller
public class DwItemDescController {
	@Resource
	private DwItemDescService dwItemDescServiceImpl;
	/**
	 * 显示商品详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="item/desc/{id}.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String desc(@PathVariable long id){
		return dwItemDescServiceImpl.showDesc(id);
	}
}
