package com.iread.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iread.admin.domain.Writer;
import com.iread.admin.service.WriterService;

/**
 *项目名称: iAdmin
 *类名称: WriterController
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月18日下午4:27:56
 * @version
 * @author 方秋都
 *
 */
@Controller
public class WriterController {
	private static final String PREFIX = "book/";//前缀 
	@Autowired
	private WriterService writer;
	
	@RequestMapping("writers")
	public String writers(int p,Model model){
		model.addAttribute("writers",writer.writers(p));
		return PREFIX + "writerList";
	}
	
	@RequestMapping("addwri")
	public String addWriter(){
		return PREFIX + "addWriter";
	}
	
	@RequestMapping(value="addwriter",method=RequestMethod.POST)
	@ResponseBody
	public Integer addWriter(String gender,String name, String summary,Model model){
		
		return writer.insertWriter(name, gender, summary);
	}
	@RequestMapping("setWcover")
	public String  setWriterCover(int id,@RequestParam("wcover") MultipartFile file,Model model,HttpServletRequest request){
		if(file.isEmpty()){
			return "redirect:wrifos?wid=" + id;
        }
		boolean success = writer.setWriterCover(id, file,request);
		if(!success){
			return "redirect:wrifos?wid=" + id;
		}
		model.addAttribute("writer", writer.writer(id));
		return PREFIX + "writerInfo";
	}
	
	@RequestMapping("wrifos")
	public String changeWriter(int wid, Model model){
		model.addAttribute("writer", writer.writer(wid));
		return PREFIX + "writerInfo";
	}
	@RequestMapping(value="chagewriter",method=RequestMethod.POST)
	@ResponseBody
	public String changeWriter(int wid,String name, String gender, String summary,Model model){
		writer.changeWriterInfos(wid, name, gender, summary);
		return "事务提交更改";
	}
	
	@RequestMapping(value="optionwriters",method=RequestMethod.POST)
	@ResponseBody
	public List<Writer> writers(String info){
		return writer.writers(info);
	}
	
}
