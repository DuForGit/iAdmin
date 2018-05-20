package com.iread.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iread.admin.domain.BookInfosOfForm;
import com.iread.admin.domain.Chapter;
import com.iread.admin.domain.Text;
import com.iread.admin.domain.Type;
import com.iread.admin.service.BookService;
import com.iread.admin.util.SessionKeyUtil;

/**
 *项目名称: iAdmin
 *类名称: BookController
 *类描述: 图书模块控制器
 *创建人: Administrator
 *创建时间: 2018年2月21日下午4:40:31
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class BookController {
	@Autowired
	private BookService bs;
	private static final String PREFIX = "book/";//前缀
	
	
	@RequestMapping("/bookInfo")
	public String showBookInfos(int bid,Model model){
		System.out.println("bookInfo");
		model.addAttribute(bs.showBookInfos(bid));
		System.out.println(bs.showBookInfos(bid));
		return PREFIX + "bookInfo";
	}
	
	//添加Book基本信息
	@RequestMapping(value="addnewBook",method=RequestMethod.POST)
	@ResponseBody
	public Integer addNewBook(BookInfosOfForm form){
		System.out.println("form: "+form);
		bs.addBookInfos(form);
		System.out.println("id：" + form.getId());
		return form.getId();
	}
	
	//更改book信息
	@RequestMapping("change")
	public String changeBookInfos(int bid, Model model){
		model.addAttribute(bs.showBookInfos(bid));
		List<com.iread.admin.domain.Class> clazzs = bs.getClasss();
		com.iread.admin.domain.Class clazz = clazzs.get(0);
		List<Type> types = bs.getType(clazz.getId());
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("types",types);
		model.addAttribute("writers", bs.getWriters());
		model.addAttribute("publishs", bs.getPublishs());
		return PREFIX +"change";
	}
	
	@RequestMapping(value="changeBookInfos",method=RequestMethod.POST)
	@ResponseBody
	public String setChangeInfos(BookInfosOfForm form){
		System.out.println(form);
		bs.changeBookInfos(form);
		return "bookInfo?bid=" + form.getId();
	}
	
	@RequestMapping(value="setimg",method=RequestMethod.POST)
	public String changeCover(HttpServletRequest request,int id,@RequestParam("coverImg") MultipartFile file){
		if(file.isEmpty()){
			return "redirect:change?bid=" + id;
        }
		bs.setBookCover(id, file,request);
		
		/*String fileName = file.getOriginalFilename();//获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取后缀
		String bootFile = UUID.randomUUID() + suffixName;//生成唯一名称
*/		/*try {
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(
							new File("src/main/resources/static/images/book/"+bootFile)));
			out.write(file.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			return "redirect:change?bid=" + bid;
		}*/
		
		
		return "redirect:change?bid=" + id;	
	}
	
	
	@RequestMapping(value="types",method=RequestMethod.POST)
	@ResponseBody
	public List<Type> getTypes(int cid){
		return bs.getType(cid);
	}
	
	
	//添加正文
	@RequestMapping("text")
	public String addBookText(int bid,Model model){
//		request.getSession().setAttribute(SessionKeyUtil.BOOK_ID, bid);
//		request.getSession().setAttribute(SessionKeyUtil.BOOK_NAME, bs.getBookName(bid));
		model.addAttribute("bid",bid);
		model.addAttribute("chaptername", bs.getBookName(bid));
		return PREFIX +"text";
	}
	
		//添加正文
		@RequestMapping(value="addtext",method=RequestMethod.POST)
		@ResponseBody
		public String addBookText(int bid,boolean success,String chapter,String text){
			Chapter c = new Chapter();
			c.setBookId(bid);
			c.setName(chapter);
			Text t = new Text();
			t.setText(text);
			bs.addBookChapterAndText(t, c);
			if(success){
				return "bookInfo?bid=" + bid;
			}
			return "text?bid=" + bid;
		}
	
	
	
	//添加正文，以page为单位
		@RequestMapping("changetext")
		public String changeBookText(int bid,Model model){
//			request.getSession().setAttribute(SessionKeyUtil.BOOK_ID, bid);
//			request.getSession().setAttribute(SessionKeyUtil.BOOK_NAME, bs.getBookName(bid));
			
			
			List<Chapter> chapters= bs.getChapter(bid);
			if(chapters != null && !chapters.isEmpty()){
				model.addAttribute("chapters", chapters);
				model.addAttribute("bid",bid);
				model.addAttribute("chaptername", bs.getBookName(bid));
				model.addAttribute("text", bs.getText(chapters.get(0).getId()));
				System.out.println("bs.getChapter(bid):"+chapters);
				return PREFIX +"changetext";
			}
			return "redirect:text?bid=" + bid;
			
		}
		
		@RequestMapping(value="chatext",method=RequestMethod.POST)
		@ResponseBody
		public String changeBookText(int bid,int tid,int chid,boolean success,String oldChapter,String newChapter,String text){
			Chapter c = new Chapter();
			c.setId(chid);
			if(newChapter != null  && !newChapter.isEmpty()){
				c.setName(newChapter);
			}else{
				c.setName(oldChapter);
			}
			Text t =new Text();
			t.setText(text);
			t.setId(tid);
			bs.changeBookChapterAndText(t, c);
			if(success){
				return "bookInfo?bid=" + bid;
			}
			return "changetext?bid=" + bid;
		}
		
		@RequestMapping(value="getText",method=RequestMethod.POST)
		@ResponseBody
		public Text getText(int chid){
			System.out.println("bs.getText(tid):"+bs.getText(chid));
			return bs.getText(chid);
		}
		
		@RequestMapping("actions")
		public String action( int p, Model model){
			model.addAttribute("actions", bs.getActions(p));
			return PREFIX +"action";
		}
		
		@RequestMapping(value="delaction",method=RequestMethod.GET)
		public String actionInfo(int acid,Model model){
			bs.deleteAction(acid);
			model.addAttribute("actions", bs.getActions(1));
			return PREFIX +"action";
		}
		@RequestMapping(value="addaction",method=RequestMethod.GET)
		public String addActionInfo(Model model){
			model.addAttribute("books", bs.getBooksInAction());
			return PREFIX +"addaction";
		}
		
		@RequestMapping(value="setaction",method=RequestMethod.POST)
		public String setActionInfo(int bid,Model model,@RequestParam("actionImg") MultipartFile file,HttpServletRequest request){
			//System.out.println("bid：" + bid + "; images：" + file.getOriginalFilename());
			if(!file.isEmpty()){
				boolean success = bs.addAction(bid, file,request);
				if(success){
					model.addAttribute("actions", bs.getActions(1));
					return PREFIX +"action";
				}
				
			}
			model.addAttribute("books", bs.getBooksInAction());
			return PREFIX +"addaction";
		}
		
		
		/*@RequestMapping("actionInfo")
		public String actionInfo(int acid,Model model){
			model.addAttribute("action", bs.getAction(acid));
			return PREFIX +"actionInfo";
		}*/
	
}

