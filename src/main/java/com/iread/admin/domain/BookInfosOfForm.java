package com.iread.admin.domain;

import java.util.Date;

/**
 *项目名称: iAdmin
 *类名称: BookInfosOfForm
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月17日下午7:32:40
 * @version
 * @author 方秋都
 *
 */
public class BookInfosOfForm {
	private int id;
	private String name;
	//private String cover;
	private int typeId;
	private int writerId;
	private int publishId;
	private float price;
	private String summary;
	private String payaway;
	private String soldout;
	
	
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public int getPublishId() {
		return publishId;
	}
	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}
	public String getPayaway() {
		return payaway;
	}
	public void setPayaway(String payaway) {
		this.payaway = payaway;
	}
	public String getSoldout() {
		return soldout;
	}
	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}
	private int limit;
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
	/*public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}*/
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "BookInfosOfForm [id=" + id + ", name=" + name + ", typeId=" + typeId + ", writerId=" + writerId
				+ ", publishId=" + publishId + ", price=" + price + ", summary=" + summary + ", payaway=" + payaway
				+ ", soldout=" + soldout + ", limit=" + limit + "]";
	}
	
	
	
	
	
}
