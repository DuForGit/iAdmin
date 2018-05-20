package com.iread.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.admin.util.SessionKeyUtil;

/**
 *项目名称: iAdmin
 *类名称: ReSubmitInterceptor
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月12日下午9:07:40
 * @version
 * @author 方秋都
 *
 */
public class ReSubmitInterceptor implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute(SessionKeyUtil.LOGIN_RESUBIT) != null
				&& (boolean)request.getSession().getAttribute(SessionKeyUtil.LOGIN_RESUBIT) == true){
			System.out.println("防止重复提交");
			return false;
		}
		System.out.println("第一次提交，没有重复提交问题");
		return true;
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
		request.getSession().removeAttribute(SessionKeyUtil.LOGIN_RESUBIT);
	}

}
