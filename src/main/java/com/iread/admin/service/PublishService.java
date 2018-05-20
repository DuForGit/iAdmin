package com.iread.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.iread.admin.domain.Publish;
import com.iread.admin.domain.Writer;

public interface PublishService {
	Map<String, Object>publishs(int p);
	
	Publish publish(int pid);
	void changePublishInfos(int pid,String name, String summary);
	
	Integer insertPublish(String name,String summary);
	
	boolean setPublishCover(int pid,MultipartFile file,HttpServletRequest request);
	
	List<Publish>publishs(String info);
}
