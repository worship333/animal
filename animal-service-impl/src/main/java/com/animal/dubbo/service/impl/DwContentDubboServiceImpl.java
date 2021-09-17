package com.animal.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.dubbo.service.DwContentDubboService;
import com.animal.mapper.DwContentMapper;
import com.animal.pojo.DwContent;
import com.animal.pojo.DwContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class DwContentDubboServiceImpl implements DwContentDubboService {
	@Resource
	private DwContentMapper dwContentMapper;
	@Override
	public EasyUIDataGrid selContentByPage(long categoryId, int page, int rows) {
		PageHelper.startPage(page, rows);
		DwContentExample example = new DwContentExample();
		if(categoryId!=0){
			example.createCriteria().andCategoryIdEqualTo(categoryId);
		}
		List<DwContent> list = dwContentMapper.selectByExampleWithBLOBs(example);
		
		PageInfo<DwContent> pi = new PageInfo<>(list);
		
		EasyUIDataGrid datagrid = new EasyUIDataGrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}
	@Override
	public int insContent(DwContent content) {
		return dwContentMapper.insertSelective(content);
	}
	@Override
	public List<DwContent> selByCount(int count, boolean isSort) {
		DwContentExample example = new DwContentExample();
		//排序
		if(isSort){
			example.setOrderByClause("updated desc");
		}
		if(count!=0){
			PageHelper.startPage(1, count);
			List<DwContent> list = dwContentMapper.selectByExampleWithBLOBs(example);
			PageInfo<DwContent> pi = new PageInfo<>(list);
			return pi.getList();
		}else{
			return dwContentMapper.selectByExampleWithBLOBs(example);
		}
	}

}



