package com.iread.admin.util;

/**
 *项目名称: iAdmin
 *类名称: RegixUtil
 *类描述: 正则表达式工具类
 *创建人: Administrator
 *创建时间: 2018年3月12日上午12:18:46
 * @version
 * @author 方秋都
 *
 */
public class RegixUtil {
	public static final String ADMIN_NAME = "^[\u4e00-\u9fa5]+$";
	public static final String ADMIN_NUMBER = "^[0-9]{4}$";
	public static final String ADMIN_PASS = "^[0-9]{6}$";
}
