package com.iread.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.admin.dao.AdminMapper;
import com.iread.admin.domain.Admin;
import com.iread.admin.service.AdminService;

/**
 *项目名称: iAdmin
 *类名称: AdminServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月14日下午7:44:21
 * @version
 * @author 方秋都
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper admin;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.AdminService#showAdminInfos(int)
	 */
	@Override
	public Admin showAdminInfos(int aid) {
		Admin a = admin.getMyInfos(aid);
		System.out.println(a);
		return a;
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.AdminService#changePass(int, long)
	 */
	@Override
	public Integer changePass(int aid, long newpass,long oldpass) {
		Integer id = admin.changePass(aid, newpass, oldpass);
		System.out.println("changepass:" + id);
		return id;
	}

}
