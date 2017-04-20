package com.felix.pojo;

import java.util.List;
/**
 * 班级表
 * @author Felix
 */
public class Clazz {
private long id;
private String name;
private List<Student> students;
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
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}

}
