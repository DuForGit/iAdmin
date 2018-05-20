package com.iread.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *项目名称: iAdmin
 *类名称: SysAdminController
 *类描述: 系统管理员模块控制器
 *创建人: Administrator
 *创建时间: 2018年2月21日下午5:14:59
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping("sys")
public class SysAdminController {
	
	//添加管理员
	public void addAdmin(){}
	
	//删除管理员
	public void deleteAdmin(int id){}
	
	//批量删除管理员
	public void deleteAdmin(int[] ids){}
	
	//帮助其他管理员更改信息
	public boolean changeAdmin(){return true;}
	
	//动态获取其他管理员的登录密码，处理其他管理员忘记密码的情况
	public int getPassword(){return 0;}
}
