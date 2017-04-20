package com.felix.pojo;

import java.io.Serializable;
import java.util.Date;
import com.felix.utils.Sex;
/**
 * 学生表 
 * @author Felix
 *
 */
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;//
	private String name;
	private Sex sex;
	private Date birthday;
	private Clazz clazz;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", clazz=" + clazz
				+ "]";
	}
}
