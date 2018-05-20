package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Class
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:13:22
 * @version
 * @author 方秋都
 *
 */
public class Class {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + "]";
	}

}
