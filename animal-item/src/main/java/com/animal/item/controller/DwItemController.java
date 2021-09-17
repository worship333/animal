package com.animal.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.animal.item.service.DwItemService;


@Controller
public class DwItemController {
	@Resource
	private DwItemService dwItemSerivceImpl;
	
	/**
	 * 显示商品详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("item/{id}.html")
	public String showItemDetails(@PathVariable long id,Model model){
		model.addAttribute("item", dwItemSerivceImpl.show(id));
		return "item";
	}
}
