package com.iread.admin.domain;

/**
 *项目名称: iAdmin
 *类名称: Admin
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月14日下午7:40:12
 * @version
 * @author 方秋都
 *
 */
public class Admin {
	private int id;
	private int number;
	private String name;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", number=" + number + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
	
}
