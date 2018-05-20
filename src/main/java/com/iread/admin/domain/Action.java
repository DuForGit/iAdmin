package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Action
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月20日下午10:47:54
 * @version
 * @author 方秋都
 *
 */
public class Action {
	private int id;
	private String cover;
	private int bookId;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "Action [id=" + id + ", cover=" + cover + ", bookId=" + bookId + ", title=" + title + "]";
	}
	
	
}
