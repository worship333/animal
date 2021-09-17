package com.animal.portal.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.animal.portal.service.DwContentService;

@Controller
public class DwContentController {
	@Resource
	private DwContentService dwContentServiceImpl;
	
	@RequestMapping("showBigPic")
	public String showBigPic(Model model){
		model.addAttribute("ad1", dwContentServiceImpl.showBigPic());
		return "index";
	}
}
