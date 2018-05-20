package com.iread.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *项目名称: iAdmin
 *类名称: UserController
 *类描述: 用户模块控制器
 *创建人: Administrator
 *创建时间: 2018年2月21日下午3:36:58
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	//ID编号查用户的详细信息
	public String userInfos(int id){
		return "";
	}
	
	//查找被冻结的用户
	public String showFrozenAccounts(){
		return "";
	}
	
	//冻结单个用户，期限默认一周
	public boolean frozenAccount(int id){
		return true;
	}
	
	//批量冻结多个用户，期限自定
	public boolean frozenAccounts(int[] id, int days){
		return true;
	}
	
	//批量处理多条批量，TRUE为通过，FALSE为禁止，id为评论ID,pass为是否通过
	public boolean frozenComments(int[] id, boolean pass){
		return true;
	}
	
	//批量处理多条批量，TRUE为通过，FALSE为禁止
	public boolean frozenComment(int id, boolean pass){
		return true;
	}
	
}
