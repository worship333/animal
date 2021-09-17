package com.animal.cart.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.pojo.DwItemChild;



public interface CartService {
	/**
	 * 加入想要收养
	 * @param id
	 * @param num
	 */
	void addCart(long id,HttpServletRequest request);
	/**
	 * 显示想要收养
	 * @return
	 */
	List<DwItemChild> showCart(HttpServletRequest request);
	
	/**
	 * 删除想要收养动物
	 * @param id
	 * @param req
	 * @return
	 */
	AnimalResult delete(long id,HttpServletRequest req);
}
