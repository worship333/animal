package com.animal.item.controller;

import javax.annotation.Resource;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.item.service.DwItemCatService;

@Controller
public class DwItemCatController {
	@Resource
	private DwItemCatService dwItemCatServiceImpl;
	/**
	 * 返回jsonp数据格式包含所有菜单信息
	 * @param callback
	 * @return
	 */
	@RequestMapping("rest/itemcat/all")
	@ResponseBody
	public MappingJacksonValue showMenu(String callback){
		MappingJacksonValue mjv = new MappingJacksonValue(dwItemCatServiceImpl.showCatMenu());
		mjv.setJsonpFunction(callback);
		return mjv;
	}
}





