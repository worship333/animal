package com.animal.item.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.DwItemChild;
import com.animal.commons.utils.JsonUtils;
import com.animal.dubbo.service.DwItemDubboService;
import com.animal.item.service.DwItemService;
import com.animal.pojo.DwItem;
import com.animal.redis.dao.JedisDao;


@Service
public class DwItemServiceImpl implements DwItemService {
	@Reference
	private DwItemDubboService dwItemDubboServiceImpl;
	@Resource
	private JedisDao jedisDaoImpl;
	@Value("${redis.item.key}")
	private String itemKey;
	
	@Override
	public DwItemChild show(long id) {
		String key = itemKey+id;
		if(jedisDaoImpl.exists(key)){
			String json = jedisDaoImpl.get(key);
			if(json!=null&&!json.equals("")){
				return JsonUtils.jsonToPojo(json, DwItemChild.class);
			}
		}
		DwItem item = dwItemDubboServiceImpl.selById(id);
		DwItemChild child = new DwItemChild();
		child.setId(item.getId());
		child.setTitle(item.getTitle());
		child.setPoint(item.getPoint());
		child.setImages(item.getImage()!=null&&!item.equals("")?item.getImage().split(","):new String[1]);
		//存到数据库中
		jedisDaoImpl.set(key, JsonUtils.objectToJson(child));
		return child;
	}

}
