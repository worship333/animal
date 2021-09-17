package com.animal.cart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.animal.commons.pojo.AnimalResult;
import com.animal.commons.utils.CookieUtils;
import com.animal.commons.utils.HttpClientUtil;
import com.animal.commons.utils.JsonUtils;



public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		if(token!=null&&!token.equals("")){
			String json = HttpClientUtil.doPost("http://localhost:8084/user/token/"+token);
			AnimalResult er = JsonUtils.jsonToPojo(json, AnimalResult.class);
			if(er.getStatus()==200){
				return true;
			}
		}
		String num = request.getParameter("num");
		response.sendRedirect("http://localhost:8084/user/showLogin?interurl="+request.getRequestURL()+"%3Fnum="+num);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
