package com.iread.admin.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.admin.util.RegixUtil;

/**
 *项目名称: iAdmin
 *类名称: ChangePassInterceptor
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月14日下午8:37:09
 * @version
 * @author 方秋都
 *
 */
public class ChangePassInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String newpass = request.getParameter("newpass");
		String oldpass = request.getParameter("oldpass");
		if(Pattern.matches(RegixUtil.ADMIN_PASS, newpass) && 
				Pattern.matches(RegixUtil.ADMIN_PASS, oldpass)){
			System.out.println("密码格式正确");
			return true;
		}
		System.out.println("密码格式错误");
		response.sendRedirect("/changePassword");
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
