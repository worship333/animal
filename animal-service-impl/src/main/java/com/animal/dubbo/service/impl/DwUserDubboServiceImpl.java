package com.animal.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.animal.dubbo.service.DwUserDubboService;
import com.animal.mapper.DwUserMapper;
import com.animal.pojo.DwUser;
import com.animal.pojo.DwUserExample;



public class DwUserDubboServiceImpl implements DwUserDubboService {
	@Resource
	private DwUserMapper dwUserMapper;
	@Override
	public DwUser selByUser(DwUser user) {
		DwUserExample example = new DwUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<DwUser> list = dwUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
