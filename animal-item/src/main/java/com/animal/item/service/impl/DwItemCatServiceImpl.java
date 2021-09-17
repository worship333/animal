package com.animal.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.dubbo.service.DwItemCatDubboService;
import com.animal.item.pojo.PortalMenu;
import com.animal.item.pojo.PortalMenuNode;
import com.animal.item.service.DwItemCatService;
import com.animal.pojo.DwItemCat;

@Service
public class DwItemCatServiceImpl implements DwItemCatService{
	@Reference
	private DwItemCatDubboService dwItemCatDubboServiceImpl;
	@Override
	public PortalMenu showCatMenu() {
		//查询出所有一级菜单
		List<DwItemCat> list = dwItemCatDubboServiceImpl.show(0);
		PortalMenu pm =new PortalMenu();
		pm.setData(selAllMenu(list));
		return pm;
	}
	/**
	 * 最终返回结果所有查询到的结果.
	 */
	public List<Object> selAllMenu(List<DwItemCat> list){
		List<Object> listNode = new ArrayList<>();
		for (DwItemCat dwItemCat : list) {
			if(dwItemCat.getIsParent()){
				PortalMenuNode pmd  = new PortalMenuNode();
				pmd.setU("/products/"+dwItemCat.getId()+".html");
				pmd.setN("<a href='/products/"+dwItemCat.getId()+".html'>"+dwItemCat.getName()+"</a>");
				pmd.setI(selAllMenu(dwItemCatDubboServiceImpl.show(dwItemCat.getId())));
				listNode.add(pmd);
			}else{
				listNode.add("/products/"+dwItemCat.getId()+".html|"+dwItemCat.getName());
			}
		}
		return listNode;
	}
}
