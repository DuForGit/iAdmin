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

import com.iread.admin.dao.PublishMapper;
import com.iread.admin.domain.Publish;
import com.iread.admin.domain.Writer;
import com.iread.admin.service.PublishService;
import com.iread.admin.util.ImageUtil;
import com.iread.admin.util.PageUtil;

/**
 *项目名称: iAdmin
 *类名称: PublishServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月18日下午10:39:50
 * @version
 * @author 方秋都
 *
 */
@Service
public class PublishServiceImpl implements PublishService {

	@Autowired
	private PublishMapper publish;
	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#publishs(int)
	 */
	@Override
	public Map<String, Object> publishs(int p) {

		PageUtil.startPage(p);
		return PageUtil.pageInfos(publish.showPublishs());
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#publish(int)
	 */
	@Override
	public Publish publish(int pid) {
		
		return publish.publish(pid);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#changePublishInfos(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void changePublishInfos(int pid, String name, String summary) {
		publish.changePublishInfos(pid, name, summary);
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#insertPublish(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer insertPublish(String name, String summary) {
		Publish p = new Publish();
		p.setName(name);
		p.setSummary(summary);
		publish.insertPublish(p);
		return p.getId();
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#setPublishCover(int, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public boolean setPublishCover(int pid, MultipartFile file,HttpServletRequest request) {
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
							new File(imgUri + "publish/"+bootFile)));
			out.write(file.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			return false;
		}
		
		String oldCover = publish.getOldCover(pid);
		File f = new File(imgUri + "publish/"+oldCover);
		if(f.exists() && !oldCover.equals("default.jpg")){
			f.delete();
		}
		publish.changerCover(pid, bootFile);
		return true;
		
	}

	/* (non-Javadoc)
	 * @see com.iread.admin.service.PublishService#publishs(java.lang.String)
	 */
	@Override
	public List<Publish> publishs(String info) {
		
		return publish.optionPublishs(info);
	}

}
