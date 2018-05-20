package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Publish
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:05:24
 * @version
 * @author 方秋都
 *
 */
public class Publish {
	private int id;
	private String name;
	private String cover;
	private String summary;
	
	
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
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
		return "Publish [id=" + id + ", name=" + name + ", cover=" + cover + ", summary=" + summary + "]";
	}

	
	
	
}
