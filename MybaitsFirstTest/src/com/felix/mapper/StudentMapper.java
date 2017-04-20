package com.felix.mapper;

import java.util.Map;

import com.felix.pojo.Student;

public interface StudentMapper {
	public Student getStudentById(long id);
	public void insertIntoStudent(Map<String,Object> map);
}
