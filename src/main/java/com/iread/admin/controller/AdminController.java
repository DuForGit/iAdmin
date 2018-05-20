package com.iread.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *项目名称: iAdmin
 *类名称: AdminController
 *类描述: 管理员通用控制器
 *创建人: Administrator
 *创建时间: 2018年2月21日下午4:30:23
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	//查看管理员自本人的相关信息
	public String adminInfos(int id){
		return "";
	}
	
	//修改管理员自本人的登录密码
	public String changePassword(int oldPass, int newPass){
		return "";
	}
}
