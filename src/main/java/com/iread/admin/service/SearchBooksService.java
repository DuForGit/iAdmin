package com.iread.admin.service;

import java.util.List;

import com.iread.admin.domain.Book;

/**
 *项目名称: iAdmin
 *类名称: SearchBooksService
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:00:13
 * @version
 * @author 方秋都
 *
 */
public interface SearchBooksService {
	List<Book> searchBooks(int type,String info);
}
