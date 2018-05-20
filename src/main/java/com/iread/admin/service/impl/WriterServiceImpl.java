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

import com.iread.admin.dao.WriterMapper;
import com.iread.admin.domain.Writer;
import com.iread.admin.service.WriterService;
import com.iread.admin.util.ImageUtil;
import com.iread.admin.util.PageUtil;

/**
 *项目名称: iAdmin
 *类名称: WriterServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月18日下午5:07:37
 * @version
 * @author 方秋都
 *
 */
@Service
public class WriterServiceImpl implements WriterService{

	@Autowired
	private WriterMapper writer;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#writers()
	 */
	@Override
	public Map<String, Object> writers(int p) {
		System.out.println(writer.showWriters());
		PageUtil.startPage(p);
		return PageUtil.pageInfos(writer.showWriters());
	}
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#writer(int)
	 */
	@Override
	public Writer writer(int wid) {
		
		return writer.writer(wid);
	}
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#changeWriterInfos(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changeWriterInfos(int wid, String name, String gender, String summary) {
		writer.changeWriter(wid, name, gender, summary);
	}
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#insertWriter(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer insertWriter(String name, String gender, String summary) {
		Writer w = new Writer();
		w.setName(name);
		w.setGender(gender);
		w.setSummary(summary);
		writer.insertWriter(w);
		int id = w.getId();
		System.out.println("插入主键id:" + id);
		return id;
	}
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#setWriterCover(int, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public boolean setWriterCover(int wid, MultipartFile file,HttpServletRequest request) {
		if(!ImageUtil.isImage(file)){
			return false;
		}
		String fileName = file.getOriginalFilename();//获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取后缀
		String bootFile = UUID.randomUUID() + suffixName;//生成唯一名称
		String imgUri = request.getSession().getServletContext().getRealPath("images/");
		try {
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(
							new File(imgUri + "writer/"+bootFile)));
			out.write(file.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			return false;
		}
		String oldCover = writer.getOldCover(wid);
		File f = new File(imgUri + "writer/"+oldCover);
		if(f.exists() && !oldCover.equals("default.jpg")){
			f.delete();
		}
		writer.changerCover(wid, bootFile);
		return true;
		
	}
	/* (non-Javadoc)
	 * @see com.iread.admin.service.WriterService#writers(java.lang.String)
	 */
	@Override
	public List<Writer> writers(String info) {
		
		return writer.optionWriters(info);
	}

}
