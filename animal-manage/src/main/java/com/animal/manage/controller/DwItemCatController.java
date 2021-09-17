package com.animal.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.commons.pojo.EasyUiTree;
import com.animal.manage.service.DwItemCatService;

@Controller
public class DwItemCatController {
	@Resource
	private DwItemCatService dwItemCatServiceImpl;
	/**
	 * 显示动物类目
	 * @param id
	 * @return
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EasyUiTree> showCat(@RequestParam(defaultValue="0") long id){
		return dwItemCatServiceImpl.show(id);
	}
}
