package com.felix.utils;

public enum Sex {
	//利用构造函数来创建对象
	MALE("男",1),FEMALE("女",2);
	private String name;
	private int  id;
	private  Sex(String name, int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static Sex getSex(int id){
		if(id==1){
			return Sex.MALE;
		}
		else if(id==2){
			return Sex.FEMALE;
		}else{
			return null;
		}
	}
	

	

}
