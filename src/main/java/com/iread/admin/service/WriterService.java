package com.iread.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.iread.admin.domain.Writer;

/**
 *项目名称: iAdmin
 *类名称: WriterService
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月18日下午5:06:30
 * @version
 * @author 方秋都
 *
 */
public interface WriterService {
	Map<String, Object>writers(int p);
	
	Writer writer(int wid);
	void changeWriterInfos(int wid,String name, String gender, String summary);
	
	Integer insertWriter(String name,String gender,String summary);
	
	boolean setWriterCover(int wid,MultipartFile file,HttpServletRequest request);
	
	List<Writer> writers(String info);
}
