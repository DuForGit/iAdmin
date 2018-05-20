package com.iread.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iread.admin.interceptor.ChangePassInterceptor;
import com.iread.admin.interceptor.LoginInterceptor;
import com.iread.admin.interceptor.ReSubmitInterceptor;

/**
 *项目名称: iAdmin
 *类名称: LoginWebMvcConfigurerAdapter
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月12日下午8:53:43
 * @version
 * @author 方秋都
 *
 */
@Configuration
public class LoginWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ReSubmitInterceptor()).addPathPatterns("/login");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");
		registry.addInterceptor(new ChangePassInterceptor()).addPathPatterns("/newpass");
	}
}
