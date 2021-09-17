package com.animal.dubbo.service.impl;

import javax.annotation.Resource;

import com.animal.dubbo.service.DwItemDescDubboService;
import com.animal.mapper.DwItemDescMapper;
import com.animal.pojo.DwItemDesc;

public class DwItemDescDubboServiceImpl implements DwItemDescDubboService{
	@Resource
	private DwItemDescMapper dwItemDescMapper;
	@Override
	public int insDesc(DwItemDesc itemDesc) {
		return dwItemDescMapper.insert(itemDesc);
	}

	@Override
	public DwItemDesc selByItemid(long itemid) {
		return dwItemDescMapper.selectByPrimaryKey(itemid);
	}

}
