package com.iread.admin.util;

/**
 *项目名称: iAdmin
 *类名称: StringUtil
 *类描述: 关于字符串的操作工具类，处理包括出去空格等操作
 *创建人: Administrator
 *创建时间: 2018年2月14日下午3:48:35
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class StringUtil {
	
	//public final static StringUtil STRING_UTIL = new StringUtil();
	
	private StringUtil(){}
	
	//去除相关字符串
	public static void remove(StringBuilder sb, char c){
		int index = 0;
		char currentChar;
		int len = sb.length();
		while(index < len){
			currentChar = sb.charAt(index);
			if(currentChar != c)sb.append(currentChar);
		}
		//return sb;
	}
	public static StringBuilder remove(String str, char c){
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0;
		char currentChar;
		int len = str.length();
		while(index < len){
			currentChar = str.charAt(index++);
			if(currentChar != c)stringBuilder.append(currentChar);
		}
		return stringBuilder;
	}
	
	public static String removeString(String str, char c){
		return remove(str, c).toString();
	}

	public static StringBuilder removeBlankSpace(String str){
		return remove(str, ' ');
	}
	
	public static String removeBlankSpaceString(String str){
		return removeString(str, ' ');
	}
	
}
