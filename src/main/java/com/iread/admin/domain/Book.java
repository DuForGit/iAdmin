package com.iread.admin.domain;

import java.io.Serializable;

/**
 * class
 *
 * @author 方秋都
 * @date 2018/2/8 0008
 * @description
 */
public class Book implements Serializable{
    private static final long serialVersionUID = 42L;
    private int id;
    private String name;
    private Writer writer;
    private Publish publish;
    private String cover;
    private float price;
    private Type type;
    
    

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
		return "Book [id=" + id + ", name=" + name + ", writer=" + writer + ", publish=" + publish + ", cover=" + cover
				+ ", price=" + price + ", type=" + type + "]";
	}
    
    
    
}
