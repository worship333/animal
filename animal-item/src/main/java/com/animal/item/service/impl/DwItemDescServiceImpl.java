package com.animal.item.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.dubbo.service.DwItemDescDubboService;
import com.animal.item.service.DwItemDescService;
import com.animal.redis.dao.JedisDao;

@Service
public class DwItemDescServiceImpl implements DwItemDescService {
	@Reference
	private DwItemDescDubboService dwItemDescDubboServiceImpl;
	@Resource
	private JedisDao jedisDaoImpl;
	@Value("${redis.desc.key}")
	private String descKey;
	@Override
	public String showDesc(long itemId) {
		String key = descKey + itemId;
		if(jedisDaoImpl.exists(key)){
			String json = jedisDaoImpl.get(key);
			if(json!=null&&!json.equals("")){
				return json;
			}
		}
		String result = dwItemDescDubboServiceImpl.selByItemid(itemId).getItemDesc();
		jedisDaoImpl.set(key, result);
		return result;
	}

}


