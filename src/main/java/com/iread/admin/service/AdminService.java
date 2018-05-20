package com.iread.admin.service;

import com.iread.admin.domain.Admin;

/**
 *项目名称: iAdmin
 *类名称: AdminService
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月14日下午7:39:26
 * @version
 * @author 方秋都
 *
 */
public interface AdminService {
	Admin showAdminInfos(int aid);
	Integer changePass(int aid, long newpass,long oldpass);
}
