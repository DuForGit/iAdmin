package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Writer
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:04:22
 * @version
 * @author 方秋都
 *
 */
public class Writer {
	private int id;
	private String name;
	private String gender;
	private String cover;
	private String summary = "暂无介绍";
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
		return "Writer [id=" + id + ", name=" + name + ", gender=" + gender + ", cover=" + cover + ", summary="
				+ summary + "]";
	}


}
