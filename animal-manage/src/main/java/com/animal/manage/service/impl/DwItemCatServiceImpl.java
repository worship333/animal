package com.animal.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.EasyUiTree;
import com.animal.dubbo.service.DwItemCatDubboService;
import com.animal.manage.service.DwItemCatService;
import com.animal.pojo.DwItemCat;
@Service
public class DwItemCatServiceImpl implements DwItemCatService {
	@Reference
	private DwItemCatDubboService dwItemCatDubboServiceImpl;
	@Override
	public List<EasyUiTree> show(long pid) {
		List<DwItemCat> list = dwItemCatDubboServiceImpl.show(pid);
		List<EasyUiTree> listTree = new ArrayList<>();
		for (DwItemCat cat : list) {
			EasyUiTree tree = new EasyUiTree();
			tree.setId(cat.getId());
			tree.setText(cat.getName());
			tree.setState(cat.getIsParent()?"closed":"open");
			listTree.add(tree);
		}
		return listTree;
	}
}
