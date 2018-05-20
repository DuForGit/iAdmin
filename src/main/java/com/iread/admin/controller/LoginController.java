package com.iread.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iread.admin.service.LoginService;
import com.iread.admin.util.SessionKeyUtil;

/**
 *项目名称: iAdmin
 *类名称: LoginController
 *类描述: 登录处理器
 *创建时间: 2018年2月13日上午1:02:52
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class LoginController {
	@Autowired
	LoginService login;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, String name, int password,Model model){
		request.getSession().setAttribute(SessionKeyUtil.LOGIN_RESUBIT, true);//表示数据已提交
		Integer aid = login.getAdminId(name, password);
		System.out.println("aid: " + aid);
		System.out.println(name + "  " + password);
		if(aid != null){
			request.getSession().setAttribute(SessionKeyUtil.USER_ID, aid);
			System.out.println("登录成功");
			return "redirect:/home";
		}
		System.out.println("登录失败");
		return "redirect:/index.html";
		}
	
	@RequestMapping("quit")
	public String quit(HttpServletRequest request){
		request.getSession().removeAttribute(SessionKeyUtil.USER_ID);
		return "redirect:/index.html";
	}
}
