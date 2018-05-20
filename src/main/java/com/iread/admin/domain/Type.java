package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Type
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:11:25
 * @version
 * @author 方秋都
 *
 */
public class Type {
	private int id;
	private String name;
	private Class clazz;
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
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", clazz=" + clazz + "]";
	}
	
	
}
