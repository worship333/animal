package com.animal.manage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.EasyUIDataGrid;
import com.animal.commons.utils.HttpClientUtil;
import com.animal.commons.utils.IDUtils;
import com.animal.commons.utils.JsonUtils;
import com.animal.dubbo.service.DwItemDescDubboService;
import com.animal.dubbo.service.DwItemDubboService;
import com.animal.manage.service.DwItemService;
import com.animal.pojo.DwItem;
import com.animal.pojo.DwItemDesc;
import com.animal.redis.dao.JedisDao;

@Service
public class DwItemServiceImpl implements DwItemService{
	@Reference
	private DwItemDubboService dwItemDubboServiceImpl;
	@Reference
	private DwItemDescDubboService dwItemDescDubboService;
	@Value("${search.url}")
	private String url ;
	@Resource
	private JedisDao jedisDaoImpl;
	@Value("${redis.item.key}")
	private String itemKey;
	
	public EasyUIDataGrid show(int page, int rows) {
		return dwItemDubboServiceImpl.show(page, rows);
	}
	
	@Override
	public int update(String ids, byte status) {
		int index = 0;
		DwItem item = new DwItem();
		String[] idsStr = ids.split(",");
		for (String id : idsStr) {
			item.setId(Long.parseLong(id));
			item.setStatus(status);
			index += dwItemDubboServiceImpl.updItemStatus(item);
			if(status==2||status==3){
				jedisDaoImpl.del(itemKey+id);
			}
		}
		if (index == idsStr.length) {
			return 1;
		}
		return 0;
	}

	@Override
	public int save(DwItem item, String desc) throws Exception {
				// 调用dubbo中考虑事务回滚功能方法
				long id = IDUtils.genItemId();
				item.setId(id);
				Date date = new Date();
				item.setCreated(date);
				item.setUpdated(date);
				item.setStatus((byte) 1);

				DwItemDesc itemDesc = new DwItemDesc();
				itemDesc.setItemDesc(desc);
				itemDesc.setItemId(id);
				itemDesc.setCreated(date);
				itemDesc.setUpdated(date);

				int index = 0;
				index = dwItemDubboServiceImpl.insDwItemDesc(item, itemDesc);
				
				System.out.println("index:" + index);
				
				final DwItem itemFinal = item;
				final String descFinal = desc;
				new Thread(){
					public void run() {
						Map<String,Object> map = new HashMap<>();
						map.put("item", itemFinal);
						map.put("desc", descFinal);
						
						HttpClientUtil.doPostJson(url, JsonUtils.objectToJson(map));
						//使用java代码调用其他项目的控制器
					};
				}.start();
				
				return index;
			}
}
	
	


