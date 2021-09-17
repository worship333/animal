package com.animal.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.manage.service.DwItemService;
import com.animal.pojo.DwItem;

@Controller
public class DwItemController {
	@Resource
	private DwItemService dwItemServiceImpl;
	/**
	 * 分页显示动物
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public EasyUIDataGrid show(int page,int rows){
		return dwItemServiceImpl.show(page, rows);
	}
	
	/**
	 * 显示动物修改
	 * @return
	 */
	@RequestMapping("rest/page/item-edit")
	public String showItemEdit(){
		return "item-edit";
	}
	
	/**
	 * 动物已被收养
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/delete")
	@ResponseBody
	public AnimalResult delete(String ids){
		AnimalResult er = new AnimalResult();
		int index = dwItemServiceImpl.update(ids, (byte)3);
		if(index==1){
			er.setStatus(200);
		}
		return er;
	}
	/**
	 * 动物现在无法被收养
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/instock")
	@ResponseBody
	public AnimalResult instock(String ids){
		AnimalResult er = new AnimalResult();
		int index = dwItemServiceImpl.update(ids, (byte)2);
		if(index==1){
			er.setStatus(200);
		}
		return er;
	}
	/**
	 * 动物可以被收养
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/reshelf")
	@ResponseBody
	public AnimalResult reshelf(String ids){
		AnimalResult er = new AnimalResult();
		int index = dwItemServiceImpl.update(ids, (byte)1);
		if(index==1){
			er.setStatus(200);
		}
		return er;
	}
	
	/**
	 * 动物新增
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping("item/save")
	@ResponseBody
	public AnimalResult insert(DwItem item,String desc){
		
		AnimalResult er = new AnimalResult();
		int index;
		try {
			index = dwItemServiceImpl.save(item, desc);
			System.out.println("controler:index:"+index);
			if(index==1){
				er.setStatus(200);
			}
		} catch (Exception e) {
			er.setData(e.getMessage());
		}
		return er;
	}
}
