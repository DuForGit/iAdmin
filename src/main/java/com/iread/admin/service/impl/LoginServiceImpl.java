package com.iread.admin.service.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.admin.dao.AdminMapper;
import com.iread.admin.service.LoginService;
import com.iread.admin.util.RegixUtil;

/**
 *项目名称: iAdmin
 *类名称: LoginServiceImpl
 *类描述: 登录的具体实现
 *创建人: Administrator
 *创建时间: 2018年3月12日上午12:05:20
 * @version
 * @author 方秋都
 *
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	AdminMapper admin;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.LoginService#getAdminId(java.lang.String, int)
	 */
	@Override
	public Integer getAdminId(String info, int pass) {
		Integer id;
		if(Pattern.matches(RegixUtil.ADMIN_NAME, info)){
			id = admin.getAdminIdByName(info, pass);
			System.out.println("id: " + id);
		}else{
			Integer number = Integer.valueOf(info);
			id = admin.getAdminIdByNumber(number, pass);
		}
		return id;
	}

}
