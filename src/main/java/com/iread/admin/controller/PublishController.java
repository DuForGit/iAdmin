package com.iread.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iread.admin.domain.Publish;
import com.iread.admin.service.PublishService;
import com.iread.admin.service.WriterService;


@Controller
public class PublishController {
	private static final String PREFIX = "book/";//前缀 
	@Autowired
	private PublishService publish;
	
	@RequestMapping("publishs")
	public String writers(int p,Model model){
		model.addAttribute("publishs",publish.publishs(p));
		return PREFIX + "publishList";
	}
	
	@RequestMapping("addpub")
	public String addWriter(){
		return PREFIX + "addPublish";
	}
	
	@RequestMapping(value="addpublish",method=RequestMethod.POST)
	@ResponseBody
	public Integer addWriter(String name, String summary,Model model){
		
		return publish.insertPublish(name, summary);
	}
	@RequestMapping("setPcover")
	public String  setWriterCover(int id,@RequestParam("pcover") MultipartFile file,Model model,HttpServletRequest request){
		if(file.isEmpty()){
			return "redirect:pbifos?pid=" + id;
        }
		boolean success = publish.setPublishCover(id, file,request);
		if(!success){
			return "redirect:pbifos?pid=" + id;
		}
		model.addAttribute("publish", publish.publish(id));
		return PREFIX + "publishInfo";
	}
	
	@RequestMapping("pbifos")
	public String changeWriter(int pid, Model model){
		model.addAttribute("publish", publish.publish(pid));
		return PREFIX + "publishInfo";
	}
	@RequestMapping(value="chagepublish",method=RequestMethod.POST)
	@ResponseBody
	public String changeWriter(int pid,String name, String summary,Model model){
		publish.changePublishInfos(pid, name, summary);
		return "事务提交更改";
	}
	
	@RequestMapping(value="optionpublishs",method=RequestMethod.POST)
	@ResponseBody
	public List<Publish> publish(String info){
		return publish.publishs(info);
	}
	
}
