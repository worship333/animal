package com.animal.cart.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.cart.service.CartService;
import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.DwItemChild;
import com.animal.commons.utils.CookieUtils;
import com.animal.commons.utils.HttpClientUtil;
import com.animal.commons.utils.JsonUtils;
import com.animal.dubbo.service.DwItemDubboService;
import com.animal.pojo.DwItem;
import com.animal.redis.dao.JedisDao;


@Service
public class CartServiceImpl implements CartService {
	@Resource
	private JedisDao jedisDaoImpl;
	@Reference
	private DwItemDubboService dwItemDubboServiceImpl;
	@Value("${passport.url}")
	private String passportUrl;
	@Value("${cart.key}")
	private String cartKey;
	@Override
	public void addCart(long id,HttpServletRequest request) {
		//集合中存放所有想要收养动物
		List<DwItemChild> list  = new ArrayList<>();
		//redis中的key
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		String jsonUser = HttpClientUtil.doPost(passportUrl+token);
		AnimalResult er = JsonUtils.jsonToPojo(jsonUser, AnimalResult.class);
		String key = cartKey+((LinkedHashMap)er.getData()).get("username");
		
		//如果redis中存在key
		if(jedisDaoImpl.exists(key)){
			String json = jedisDaoImpl.get(key);
			if(json!=null&&!json.equals("")){
				list = JsonUtils.jsonToList(json, DwItemChild.class);
				for (DwItemChild dwItemChild : list) {
					if((long)dwItemChild.getId()==id){
						//想要收养中存在该动物
						jedisDaoImpl.set(key, JsonUtils.objectToJson(list));
						return ;
					}
				}
				//重新添加到redis中
			}
		}
		DwItem item = dwItemDubboServiceImpl.selById(id);
		DwItemChild child = new DwItemChild();
		
		child.setId(item.getId());
		child.setTitle(item.getTitle());
		child.setImages(item.getImage()==null||item.getImage().equals("")?new String[1]:item.getImage().split(","));
		
		list.add(child);
		
		
		jedisDaoImpl.set(key, JsonUtils.objectToJson(list));
	}
	@Override
	public List<DwItemChild> showCart(HttpServletRequest request) {
		//redis中的key
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		String jsonUser = HttpClientUtil.doPost(passportUrl+token);
		AnimalResult er = JsonUtils.jsonToPojo(jsonUser, AnimalResult.class);
		String key = cartKey+((LinkedHashMap)er.getData()).get("username");
		
		String json = jedisDaoImpl.get(key);
		return JsonUtils.jsonToList(json, DwItemChild.class);
	}
//	
	@Override
	public AnimalResult delete(long id, HttpServletRequest req) {
		//redis中的key
		String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
		String jsonUser = HttpClientUtil.doPost(passportUrl+token);
		AnimalResult er = JsonUtils.jsonToPojo(jsonUser, AnimalResult.class);
		String key = cartKey+((LinkedHashMap)er.getData()).get("username");
		
		String json = jedisDaoImpl.get(key);
		List<DwItemChild> list = JsonUtils.jsonToList(json, DwItemChild.class);
		DwItemChild dwItemChild = null;
		for (DwItemChild child : list) {
			if((long)child.getId()==id){
				dwItemChild = child;
			}
		}
		list.remove(dwItemChild);
		String ok = jedisDaoImpl.set(key, JsonUtils.objectToJson(list));
		AnimalResult animalResult = new AnimalResult();
		if(ok.equals("OK")){
			animalResult.setStatus(200);
		}
		return animalResult;
	}

}
