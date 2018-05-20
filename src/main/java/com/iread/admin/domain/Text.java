package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Text
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月19日下午10:52:31
 * @version
 * @author 方秋都
 *
 */
public class Text {
	private int id;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Text [id=" + id + ", text=" + text + "]";
	}
	
	
	
}
