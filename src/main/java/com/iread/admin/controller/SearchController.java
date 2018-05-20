package com.iread.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iread.admin.domain.Book;
import com.iread.admin.service.SearchBooksService;

/**
 *项目名称: iAdmin
 *类名称: SearchController
 *类描述: 搜索控制器
 *创建人: Administrator
 *创建时间: 2018年2月21日下午3:12:16
 * @version 1.0.0
 * @author 方秋都
 *
 */
@RestController
@RequestMapping("search")
public class SearchController {
	
	@Autowired
	private SearchBooksService books;
	@RequestMapping("books")
	public List<Book> searchBook(int type, String info){
		
		return books.searchBooks(type, info);
	}
	
	
	
	
	
	/**
	 * 
	 *方法名: searchUser
	 *描述: 根据类型和内容搜索相关用户信息，并返回相关视图
	 * @param type 搜索类型
	 * @param info 搜索内容
	 * @return String 视图名称
	 */
	public String searchUser(String type, String info){
		return "";
	}
	
	/**
	 * 
	 *方法名: searchBookById
	 *描述: 根据ID查图书
	 * @param id id号
	 * @return 视图
	 */
	public String searchBookById(int id){
		return "";
	}
	
	
	//clazz: 类型; type: 类型细分，如果type为默认则根据clazz查找
	public String searchBooks(String clazz, String type){
		return "";
	}
	
	//根据作者查图书
	public String searchBookByAuthor(String name){
		return "";
	}
	//根据出版社查图书
	public String searchBookByPublish(String publish){
		return "";
	}
	
	//根据ID查管理员
	public String searchAdminById(int id){
		return "";
	}
	//根据姓名查管理员
	public String searchAdminByName(String name){
		return "";
	}
	
	//根据工号查管理员
	public String searchBookByNumber(int num){
		return "";
	}
	
	//根据身份证查管理员
	public String searchBookByCardId(int cardId){
		return "";
	}
	
}
