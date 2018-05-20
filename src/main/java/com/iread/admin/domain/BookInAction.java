package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: BookInAction
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月21日下午9:05:38
 * @version
 * @author 方秋都
 *
 */
public class BookInAction {
	private int id;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BookInAction [id=" + id + ", title=" + title + "]";
	}
	
}
