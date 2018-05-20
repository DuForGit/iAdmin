package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Chapter
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月19日下午10:42:41
 * @version
 * @author 方秋都
 *
 */
public class Chapter {
	private int id;
	private String name;
	private int textId;
	private int bookId;
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
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", textId=" + textId + ", bookId=" + bookId + "]";
	}
	
}
