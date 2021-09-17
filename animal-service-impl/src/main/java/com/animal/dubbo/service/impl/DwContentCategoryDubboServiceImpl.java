package com.animal.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.animal.dubbo.service.DwContentCategoryDubboService;
import com.animal.mapper.DwContentCategoryMapper;
import com.animal.pojo.DwContentCategory;
import com.animal.pojo.DwContentCategoryExample;

public class DwContentCategoryDubboServiceImpl implements DwContentCategoryDubboService {
	@Resource
	private DwContentCategoryMapper dwContentCategoryMapper;

	@Override
	public List<DwContentCategory> selByPid(long id) {
		DwContentCategoryExample example = new DwContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id).andStatusEqualTo(1);
		return dwContentCategoryMapper.selectByExample(example);
	}

	@Override
	public int insDwContentCategory(DwContentCategory cate) {
		return dwContentCategoryMapper.insertSelective(cate);
	}

	@Override
	public int updIsParentById(DwContentCategory cate) {
		return dwContentCategoryMapper.updateByPrimaryKeySelective(cate);
	}

	@Override
	public DwContentCategory selById(long id) {
		return dwContentCategoryMapper.selectByPrimaryKey(id);
	}
	
}