package com.iread.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *项目名称: iAdmin
 *类名称: BookCoverWebMvcConfigurerAdapter
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月18日下午3:53:17
 * @version
 * @author 方秋都
 *
 */
@Configuration
public class BookCoverWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("src/main/webapp/**").addResourceLocations("classpath:/webapp");
		
	}
}
