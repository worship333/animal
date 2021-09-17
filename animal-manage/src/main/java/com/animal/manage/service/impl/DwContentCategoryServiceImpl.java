package com.animal.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.EasyUiTree;
import com.animal.commons.utils.IDUtils;
import com.animal.dubbo.service.DwContentCategoryDubboService;
import com.animal.manage.service.DwContentCategoryService;
import com.animal.pojo.DwContentCategory;


@Service
public class DwContentCategoryServiceImpl implements DwContentCategoryService {
	@Reference
	private DwContentCategoryDubboService dwContentCategoryDubboServiceImpl;
	@Override
	public List<EasyUiTree> showCategory(long id) {
		List<EasyUiTree> listTree = new ArrayList<EasyUiTree>();
		List<DwContentCategory> list = dwContentCategoryDubboServiceImpl.selByPid(id);
		for (DwContentCategory cate : list) {
			EasyUiTree tree = new EasyUiTree();
			
			tree.setId(cate.getId());
			tree.setText(cate.getName());
			tree.setState(cate.getIsParent()?"closed":"open");
			
			listTree.add(tree);
		}
		return listTree;
	}
	
	@Override
	public AnimalResult create(DwContentCategory cate) {
		
		AnimalResult er = new AnimalResult();
		
		//判断当前节点名称是否已经存在
		
		List<DwContentCategory> children = dwContentCategoryDubboServiceImpl.selByPid(cate.getParentId());
		for (DwContentCategory child : children) {
			if(child.getName().equals(cate.getName())){
				er.setData("该分类名已存在");
				return er;
			}
		}
		
		Date date = new Date();
		cate.setCreated(date);
		cate.setUpdated(date);
		cate.setStatus(1);
		cate.setSortOrder(1);
		cate.setIsParent(false);
		long id = IDUtils.genItemId();
		cate.setId(id);
		int index = dwContentCategoryDubboServiceImpl.insDwContentCategory(cate);
		if(index>0){
			DwContentCategory parent = new DwContentCategory();
			parent.setId(cate.getParentId());
			parent.setIsParent(true);
			dwContentCategoryDubboServiceImpl.updIsParentById(parent);
		}
		er.setStatus(200);
		Map<String,Long> map = new HashMap<>();
		map.put("id", id);
		er.setData(map);
		return er;
	}
	
	@Override
	public AnimalResult update(DwContentCategory cate) {
		AnimalResult er = new AnimalResult();
		//查询当前节点信息
		DwContentCategory cateSelect = dwContentCategoryDubboServiceImpl.selById(cate.getId());
		//查询当前节点的父节点的所有子节点信息
		List<DwContentCategory> children = dwContentCategoryDubboServiceImpl.selByPid(cateSelect.getParentId());
		for (DwContentCategory child : children) {
			if(child.getName().equals(cate.getName())){
				er.setData("该分类名已存在");
				return er;
			}
		}
		int index = dwContentCategoryDubboServiceImpl.updIsParentById(cate);
		if(index>0){
			er.setStatus(200);
		}
		
		return er;
	}
	
	@Override
	public AnimalResult delete(DwContentCategory cate) {
		
		AnimalResult er = new AnimalResult();
		
		cate.setStatus(0);
		int index = dwContentCategoryDubboServiceImpl.updIsParentById(cate);
		if(index>0){
			DwContentCategory curr = dwContentCategoryDubboServiceImpl.selById(cate.getId());
			List<DwContentCategory> list = dwContentCategoryDubboServiceImpl.selByPid(curr.getParentId());
			if(list==null||list.size()==0){
				DwContentCategory parent = new DwContentCategory();
				parent.setId(curr.getParentId());
				parent.setIsParent(false);
				int result = dwContentCategoryDubboServiceImpl.updIsParentById(parent);
				if(result>0){
					er.setStatus(200);
				}
			}else{
				er.setStatus(200);
			}
		}
		return er;
	}

}
