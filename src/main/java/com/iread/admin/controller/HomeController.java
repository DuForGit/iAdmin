package com.iread.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iread.admin.domain.Book;
import com.iread.admin.domain.Type;
import com.iread.admin.service.AdminService;
import com.iread.admin.service.BookService;
import com.iread.admin.util.SessionKeyUtil;

/**
 *项目名称: iAdmin
 *类名称: IndexController
 *类描述: 登录页面的映射
 *创建人: Administrator
 *创建时间: 2018年2月12日下午8:19:00
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
//@EnableAutoConfiguration
public class HomeController {
	private static final String PREFIX = "book/";//前缀
	private static final String ADMIN = "admin/";
	private static final String USER = "user/";
	
	@RequestMapping("userwords")
	public String words(){
		return USER + "wordsList";
	}
	@RequestMapping("wordsInfo")
	public String wordsInfo(){
		return USER + "wordsInfo";
	}
	@RequestMapping("comments")
	public String comments(){
		return USER + "comment";
	}
	
	@RequestMapping("users")
	public String uers(){
		return USER + "userList";
	}
	@RequestMapping("userInfo")
	public String userInfo(){
		return USER + "info";
	}
	
	
	@RequestMapping("admins")
	public String admins(){
		return ADMIN + "adminList";
	}
	@RequestMapping("addAdmin")
	public String addAdmin(){
		return ADMIN + "add";
	}
	@RequestMapping("changAdminInfo")
	public String changAdminInfo(HttpServletRequest request,Model model){
		int aid = (int) request.getSession().getAttribute(SessionKeyUtil.USER_ID);
		return ADMIN + "changeInfo";
	}
/*	@RequestMapping("changeAdminPass")
	public String changeAdminPass(){
		return ADMIN + "changePassword";
	}*/
	@Autowired
	private AdminService admin;
	
	@RequestMapping("adminInfo")
	public String adminInfo(HttpServletRequest request,Model model){
		int aid = (int) request.getSession().getAttribute(SessionKeyUtil.USER_ID);
		model.addAttribute(admin.showAdminInfos(aid));
		return ADMIN + "info";
	}
	
	
	
	
	@RequestMapping("/home")
	public String home(){
		/*m.put("name", "方秋都");
		System.out.println("home");*/
		return "home";
	}
	@RequestMapping("/main")
	public String main(){
		System.out.println("main");
		return PREFIX + "main";
	}
	@RequestMapping("/action")
	public String action(){
		System.out.println("action");
		return PREFIX + "action";
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		List<com.iread.admin.domain.Class> clazzs = bs.getClasss();
		com.iread.admin.domain.Class clazz = clazzs.get(0);
		List<Type> types = bs.getType(clazz.getId());
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("types",types);
		model.addAttribute("writers", bs.getWriters());
		model.addAttribute("publishs", bs.getPublishs());
		return PREFIX + "add";
	}
	
	@RequestMapping("/adv")
	public String adv(){
		System.out.println("adv");
		return PREFIX + "adv";
	}
	
	@RequestMapping("/book")
	public String book(){
		System.out.println("book");
		return PREFIX + "book";
	}
	
	/*@RequestMapping("/bookInfo")
	public String bookInfo(int bid,Model model){
		System.out.println("bookInfo");
		return PREFIX + "bookInfo";
	}*/
	
	@RequestMapping("/cate")
	public String cate(){
		System.out.println("cate");
		return PREFIX + "cate";
	}
	
	@RequestMapping("/cateedit")
	public String cateedit(){
		System.out.println("cateedit");
		return PREFIX + "cateedit";
	}
	@RequestMapping("/column")
	public String column(){
		System.out.println("column");
		return PREFIX + "column";
	}
	@RequestMapping("/info")
	public String info(){
		System.out.println("info");
		return PREFIX + "info";
	}
	@Autowired
	private BookService bs;
	
	@RequestMapping("/bookList")
	public String list(int p, Model model){
		model.addAllAttributes(bs.getBooks(p));
		System.out.println("booklist");
		return PREFIX + "bookList";
	}
	/*@RequestMapping("/login")
	public String login(){
		System.out.println("login");
		return PREFIX + "login";
	}*/
	@RequestMapping("/page")
	public String page(){
		System.out.println("page");
		return PREFIX + "page";
	}
	
	@RequestMapping("/changeInfo")
	public String changeInfo(){
		System.out.println("changeInfo");
		return PREFIX + "changeInfo";
	}
	/*@RequestMapping("/change")
	public String change(){
		System.out.println("change");
		return PREFIX + "change";
	}*/
	@RequestMapping("/changePassword")
	public String changePassword(HttpServletRequest request,Model model){
		System.out.println("changePassword");
		int aid = (int) request.getSession().getAttribute(SessionKeyUtil.USER_ID);
		model.addAttribute(admin.showAdminInfos(aid));
		return "changePassword";
	}
	@RequestMapping(value="/newpass",method=RequestMethod.POST)
	public String newPassword(HttpServletRequest request,long oldpass,long newpass){
		int aid = (int) request.getSession().getAttribute(SessionKeyUtil.USER_ID);
		Integer trueOfFalse = admin.changePass(aid, newpass,oldpass);
		if(trueOfFalse == 0){
			return "redirect:changePassword";
		}
		//request.getSession().removeAttribute(SessionKeyUtil.USER_ID);
		return "redirect:adminInfo";
	}
	
	
	
	
	@RequestMapping("/news")
	public String news(){
		System.out.println("news");
		return "news";
	}
	@RequestMapping("/tips")
	public String tips(){
		System.out.println("tips");
		return PREFIX + "tips";
	}
	
	
	
	/*@RequestMapping(value={"/","index","index.html","index.htm"},method=RequestMethod.GET)
	public String index(){
		System.out.println("index");
		return "index";
	}*/
	
	/*@Autowired
	BookService bs;*/
	
	/*@RequestMapping("book")
	@ResponseBody
	public List<Book> books(){
		return bs.getBooks();
	}*/
}
