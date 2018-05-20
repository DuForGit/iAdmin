package com.iread.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.iread.admin.dao")
@SpringBootApplication
@ServletComponentScan
public class IAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(IAdminApplication.class, args);
	}
	
	/**
	 * 文件上传临时路径
	 */
	/*@Bean
	 MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    factory.setLocation("/images/book/");
	    return factory.createMultipartConfig();
	}*/
	
}
