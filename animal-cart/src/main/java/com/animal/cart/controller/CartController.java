package com.animal.cart.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.animal.cart.service.CartService;
import com.animal.commons.pojo.AnimalResult;


@Controller
public class CartController {
	@Resource
	private CartService cartServiceImpl;
	/**
	 * 添加想要收养
	 * @param id
	 * @return
	 */
	@RequestMapping("cart/add/{id}.html")
	public String addCart(@PathVariable long id,HttpServletRequest request){
		cartServiceImpl.addCart(id , request);
		return "cartSuccess";
	}
	
	/**
	 * 显示想要收养
	 * @return
	 */
	@RequestMapping("cart/cart.html")
	public String showCart(Model model,HttpServletRequest request){
		model.addAttribute("cartList", cartServiceImpl.showCart(request));
		return "cart";
	}
	
	/**
	 * 删除想要收养动物
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("cart/delete/{id}.action")
	@ResponseBody
	public AnimalResult delete(@PathVariable long id,HttpServletRequest req){
		return cartServiceImpl.delete(id, req);
	}
}
