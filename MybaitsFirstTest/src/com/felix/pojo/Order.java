package com.felix.pojo;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Goods> goods;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	
}
