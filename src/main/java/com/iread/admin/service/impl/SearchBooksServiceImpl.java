package com.iread.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.admin.dao.SearchBooksMapper;
import com.iread.admin.domain.Book;
import com.iread.admin.service.SearchBooksService;

/**
 *项目名称: iAdmin
 *类名称: SearchBooksServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:01:25
 * @version
 * @author 方秋都
 *
 */
@Service
public class SearchBooksServiceImpl implements SearchBooksService {

	@Autowired
	private SearchBooksMapper mapper;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.SearchBooksService#searchBooks(int, java.lang.String)
	 */
	@Override
	public List<Book> searchBooks(int type, String info) {
		List<Book> books = new ArrayList<Book>();
		if(info!=null && info !=""){
			if(type == 0){
				books.add(mapper.searchBookById(Integer.valueOf(info)));
				
			}else{
				books = mapper.searchBooksByName(info);
			}
		}	
		System.out.println(books);
		return books;
	}


}
