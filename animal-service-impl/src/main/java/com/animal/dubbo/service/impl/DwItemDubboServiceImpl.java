package com.animal.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.dubbo.service.DwItemDubboService;
import com.animal.mapper.DwItemDescMapper;
import com.animal.mapper.DwItemMapper;
import com.animal.pojo.DwItem;
import com.animal.pojo.DwItemDesc;
import com.animal.pojo.DwItemExample;
import com.github.pagehelper.PageInfo;

public class DwItemDubboServiceImpl implements DwItemDubboService{
	@Resource
	private DwItemMapper dwItemMapper;
	@Resource
	private DwItemDescMapper dwItemDescMapper;
	
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		//查询全部
		List<DwItem> list = dwItemMapper.selectByExample(new DwItemExample());
		//分页代码
		//设置分页条件
		PageInfo<DwItem> pi = new PageInfo<>(list); //把上面查到的list放进去
		
		//放入到实体类
		EasyUIDataGrid datagrid = new EasyUIDataGrid();
		datagrid.setRows(pi.getList()); 
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}
	
	@Override
	public int updItemStatus(DwItem dwItem) {
		return dwItemMapper.updateByPrimaryKeySelective(dwItem);
	}
	
	@Override
	public int insDwItem(DwItem dwItem) {
		return dwItemMapper.insert(dwItem);
	}
	
	@Override
	public int insDwItemDesc(DwItem dwItem, DwItemDesc desc) throws Exception {
		int index =0;
		try {
			index= dwItemMapper.insertSelective(dwItem);
			index+= dwItemDescMapper.insertSelective(desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(index==2){
			return 1;
		}else{
			throw new Exception("新增失败,数据还原");
		}
	}
	
	@Override
	public List<DwItem> selAllByStatus(byte status) {
		DwItemExample example = new DwItemExample();
		example.createCriteria().andStatusEqualTo(status);
		return dwItemMapper.selectByExample(example);
	}
	
	
	@Override
	public DwItem selById(long id) {
		return dwItemMapper.selectByPrimaryKey(id);
	}

}
