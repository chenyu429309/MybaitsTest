package com.felix.pojo;

import java.io.Serializable;
/**
 * 订单表
 * @author Felix
 *
 */
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user=" + user + ", name=" + name +", User:name" + user.getName() + "]";
	}
	
}
