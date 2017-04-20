package com.felix.pojo;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Order> orders;
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
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
