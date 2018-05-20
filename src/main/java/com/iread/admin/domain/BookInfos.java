package com.iread.admin.domain;

import java.util.Date;

/**
 *项目名称: iAdmin
 *类名称: BookInfos
 *类描述: 图书详细信息
 *创建人: Administrator
 *创建时间: 2018年3月15日下午7:53:33
 * @version
 * @author 方秋都
 *
 */
public class BookInfos {
	private int id;
    private String name;
    private Writer writer;
    private Publish publish;
    private String cover;
    private float price;
    private Type type;
    private String summary;
    private int readers;
    private int comments;
    private int limit;//试读
    private int sales;
    private int searchs;
    private Date payaway;
	private Date soldout;
	
	
	
	public Date getPayaway() {
		return payaway;
	}
	public void setPayaway(Date payaway) {
		this.payaway = payaway;
	}
	public Date getSoldout() {
		return soldout;
	}
	public void setSoldout(Date soldout) {
		this.soldout = soldout;
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
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getReaders() {
		return readers;
	}
	public void setReaders(int readers) {
		this.readers = readers;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getSearchs() {
		return searchs;
	}
	public void setSearchs(int searchs) {
		this.searchs = searchs;
	}
	@Override
	public String toString() {
		return "BookInfos [id=" + id + ", name=" + name + ", writer=" + writer + ", publish=" + publish + ", cover="
				+ cover + ", price=" + price + ", type=" + type + ", summary=" + summary + ", readers=" + readers
				+ ", comments=" + comments + ", limit=" + limit + ", sales=" + sales + ", searchs=" + searchs
				+ ", payaway=" + payaway + ", soldout=" + soldout + "]";
	}
	
    
}
