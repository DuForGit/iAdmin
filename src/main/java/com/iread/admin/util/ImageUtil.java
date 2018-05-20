package com.iread.admin.util;

import org.springframework.web.multipart.MultipartFile;

/**
 *项目名称: iAdmin
 *类名称: ImageUtil
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年4月10日下午7:36:21
 * @version
 * @author 方秋都
 *
 */
public class ImageUtil {
	private static final String[] images = {"image/gif","image/jpeg","image/png"};
	private ImageUtil(){}
	public static boolean isImage(MultipartFile file){
		String im = file.getContentType();
		System.out.println("ContentType: " + im);
		for(String img : images){
			if(img.equalsIgnoreCase(im)){
				return true;
			}
		}
		return false;
	}

}
