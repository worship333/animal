package com.animal.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.animal.dubbo.service.DwItemCatDubboService;
import com.animal.mapper.DwItemCatMapper;
import com.animal.pojo.DwItemCat;
import com.animal.pojo.DwItemCatExample;

public class DwItemCatDubboServiceImpl implements DwItemCatDubboService{
	@Resource
	private DwItemCatMapper dwItemCatMapper;
	@Override
	public List<DwItemCat> show(long pid) {
		DwItemCatExample example =new DwItemCatExample();
		example.createCriteria().andParentIdEqualTo(pid);
		return dwItemCatMapper.selectByExample(example);
	}
	
	@Override
	public DwItemCat selById(long id) {
		return dwItemCatMapper.selectByPrimaryKey(id);
	}

}

