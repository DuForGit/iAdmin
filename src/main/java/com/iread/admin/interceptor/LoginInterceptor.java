package com.iread.admin.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.admin.util.RegixUtil;

/**
 *项目名称: iAdmin
 *类名称: LoginInterceptor
 *类描述: 管理员登录
 *创建人: Administrator
 *创建时间: 2018年2月12日下午11:29:17
 * @version
 * @author 方秋都
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String info = request.getParameter("name");
		//int pass = Integer.valueOf(request.getParameter("password"));
		String pass = request.getParameter("password");
		System.out.println("info:" + info);
		System.out.println("pass:" + pass);
		if((Pattern.matches(RegixUtil.ADMIN_NAME, info)
				|| Pattern.matches(RegixUtil.ADMIN_NUMBER, info))
				&& Pattern.matches(RegixUtil.ADMIN_PASS, pass)){
			System.out.println("正则表达式通过");
			return true;
		}
		System.out.println("正则表达式非法");
		response.sendRedirect("/");
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
