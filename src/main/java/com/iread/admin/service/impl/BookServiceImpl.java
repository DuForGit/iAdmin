package com.iread.admin.service.impl;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iread.admin.dao.BookMapper;
import com.iread.admin.dao.PublishMapper;
import com.iread.admin.dao.WriterMapper;
import com.iread.admin.domain.Action;
import com.iread.admin.domain.BookInAction;
import com.iread.admin.domain.BookInfos;
import com.iread.admin.domain.BookInfosOfForm;
import com.iread.admin.domain.Chapter;
import com.iread.admin.domain.Class;
import com.iread.admin.domain.Publish;
import com.iread.admin.domain.Text;
import com.iread.admin.domain.Type;
import com.iread.admin.domain.Writer;
import com.iread.admin.service.BookService;
import com.iread.admin.util.ImageUtil;
import com.iread.admin.util.PageUtil;


/**
 *项目名称: iAdmin
 *类名称: BookServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年2月12日下午8:55:16
 * @version
 * @author 方秋都
 *
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
    private BookMapper bm;

	@Override
	public Map<String,Object> getBooks(int p) {
		PageUtil.startPage(p);
		return PageUtil.pageInfos(bm.getBooks());
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#showBookInfos(int)
	 */
	@Override
	public BookInfos showBookInfos(int bid) {
		System.out.println(bm.showBookInfos(bid));
		return bm.showBookInfos(bid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getClasss()
	 */
	@Override
	public List<Class> getClasss() {
		System.out.println("classs: "+bm.getClasss());
		return bm.getClasss();
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getType(int)
	 */
	@Override
	public List<Type> getType(int cid) {
		System.out.println(bm.getTypes(cid));
		return bm.getTypes(cid);
	}

	@Autowired
	private WriterMapper writer;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getWriters()
	 */
	@Override
	public List<Writer> getWriters() {
		return writer.showWriters();
	}

	@Autowired
	private PublishMapper publish;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getPublishs()
	 */
	@Override
	public List<Publish> getPublishs() {
		
		return publish.showPublishs();
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#changeBookInfos(com.iread.admin.domain.BookInfosOfForm)
	 */
	@Override
	public Integer changeBookInfos(BookInfosOfForm form) {
		return bm.changeBookInfos(form);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#setBookCover(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public boolean setBookCover(int bid, MultipartFile file,HttpServletRequest request) {
		if(!ImageUtil.isImage(file)){//判断是否为图片格式
			return false;
		}
		String fileName = file.getOriginalFilename();//获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取后缀
		String bootFile = UUID.randomUUID() + suffixName;//生成唯一名称
		String imgUri = request.getSession().getServletContext().getRealPath("images/");
		System.out.println("路径: " + imgUri);
		try {
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(
							new File(imgUri + "/book/"+bootFile)));//src/main/webapp/images/book/
			out.write(file.getBytes());
			System.out.println("保存路径");
			out.flush();
			out.close();
		} catch (Exception e) {
			return false;
		}
		String oldCover = bm.getBookCover(bid);
		File f = new File(imgUri + "/book/"+oldCover);
		if(f.exists() && !oldCover.equals("default.jpg")){
			f.delete();
		}
		bm.setBookCover(bid, bootFile);
		return true;
		
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#addBookInfos(com.iread.admin.domain.BookInfosOfForm)
	 */
	@Override
	public Integer addBookInfos(BookInfosOfForm form) {
		
		return bm.addBookInfos(form);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getBookName(int)
	 */
	@Override
	public String getBookName(int bid) {
		
		return bm.getBookName(bid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#changeBookChapterAndText(com.iread.admin.domain.Text, com.iread.admin.domain.Chapter)
	 */
	@Override
	public void changeBookChapterAndText(Text text, Chapter chapter) {
		bm.changeText(text.getId(), text.getText());
		bm.changeChapterName(chapter.getId(), chapter.getName());
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#addBookChapterAndText(com.iread.admin.domain.Text, com.iread.admin.domain.Chapter)
	 */
	@Override
	public void addBookChapterAndText(Text text, Chapter chapter) {
		int tid = bm.addNewText(text);
		System.out.println("tid:" + tid);
		chapter.setTextId(text.getId());
		bm.addNewChapter(chapter);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getChapter(int)
	 */
	@Override
	public List<Chapter> getChapter(int bid) {
		
		return bm.getChapters(bid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getText(int)
	 */
	@Override
	public Text getText(int chid) {
		int tid = bm.selectTextID(chid);
		return bm.getTextInfos(tid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getActions()
	 */
	@Override
	public Map<String, Object> getActions(int p) {
		PageUtil.startPage(p);
		return PageUtil.pageInfos(bm.getActions());
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getAction(int)
	 */
	@Override
	public Action getAction(int acid) {
		
		return bm.getAction(acid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#changeAction(ch.qos.logback.core.joran.action.Action)
	 */
	@Override
	public void changeAction(Action action) {
		bm.changeAction(action);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#addAction(ch.qos.logback.core.joran.action.Action)
	 */
	@Override
	public boolean addAction(int bid, MultipartFile file,HttpServletRequest request) {
		if(!ImageUtil.isImage(file)){return false;}
		String fileName = file.getOriginalFilename();//获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取后缀
		String bootFile = UUID.randomUUID() + suffixName;//生成唯一名称
		String imgUri = request.getSession().getServletContext().getRealPath("images/");
		try {
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(
							new File( imgUri + "action/"+bootFile)));
			out.write(file.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			return false;
		}
		String oldCover = bm.getBookCover(bid);
		File f = new File( imgUri + "action/"+oldCover);
		if(f.exists() && !oldCover.equals("default.jpg")){
			f.delete();
		}
		Action a = new Action();
		a.setBookId(bid);
		a.setCover(bootFile);
		bm.addAction(a);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#deleteAction(int)
	 */
	@Override
	public void deleteAction(int acid) {
		bm.deleteAction(acid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.BookService#getBooksInAction()
	 */
	@Override
	public List<BookInAction> getBooksInAction() {
		
		return bm.getBooksInAction();
	}

}
