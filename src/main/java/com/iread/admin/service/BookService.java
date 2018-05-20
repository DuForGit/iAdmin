package com.iread.admin.service;

import com.iread.admin.dao.BookMapper;
import com.iread.admin.domain.Action;
import com.iread.admin.domain.Book;
import com.iread.admin.domain.BookInAction;
import com.iread.admin.domain.BookInfos;
import com.iread.admin.domain.BookInfosOfForm;
import com.iread.admin.domain.Chapter;
import com.iread.admin.domain.Class;
import com.iread.admin.domain.Publish;
import com.iread.admin.domain.Text;
import com.iread.admin.domain.Type;
import com.iread.admin.domain.Writer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * class
 *
 * @author 方秋都
 * @date 2018/2/8 0008
 * @description
 */
public interface BookService {

    Map<String,Object> getBooks(int p);
    
    BookInfos showBookInfos(int bid);
    
    List<Class> getClasss();
    
    List<Type> getType(int cid);
    
    List<Writer> getWriters();
    List<Publish> getPublishs();
    
    Integer changeBookInfos(BookInfosOfForm form);
    boolean setBookCover(int bid, MultipartFile file,HttpServletRequest request);
    Integer addBookInfos(BookInfosOfForm form);
    
    String getBookName(int bid);
    
    void changeBookChapterAndText(Text text,Chapter chapter);
    void addBookChapterAndText(Text text,Chapter chapter);
    
    List<Chapter> getChapter(int bid);
    Text getText(int tid);
    
    
    
    //推荐
    Map<String, Object>getActions(int p);
    Action getAction(int acid);
    void changeAction(Action action);
    boolean addAction(int bid, MultipartFile file,HttpServletRequest request);
    void deleteAction(int acid);
    List<BookInAction> getBooksInAction();
    
    
}
