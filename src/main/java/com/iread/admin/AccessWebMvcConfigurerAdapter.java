package com.iread.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iread.admin.interceptor.AccessInterceptor;
import com.iread.admin.interceptor.ActionInterceptor;
import com.iread.admin.interceptor.UpdateCoverInterceptor;

/**
 *项目名称: iAdmin
 *类名称: AccessWebMvcConfigurerAdapter
 *类描述: 拦截器配置类
 *创建人: Administrator
 *创建时间: 2018年3月11日下午11:15:38
 * @version
 * @author 方秋都
 *
 */
@Configuration
public class AccessWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new AccessInterceptor()).excludePathPatterns("index.html","/login");
		registry.addInterceptor(new UpdateCoverInterceptor()).addPathPatterns("/setimg","/setPcover","/setWcover");
		registry.addInterceptor(new ActionInterceptor()).addPathPatterns("/setaction");
	}
}
