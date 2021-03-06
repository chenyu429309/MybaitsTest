package com.felix.mapper;

import java.util.List;

import com.felix.pojo.Orders;
import com.felix.pojo.Person;
import com.felix.pojo.User;

public interface UserMapper {
	public User findUserById(int id);
	public List<User> findUserList();
	public User findUserByIdMap(int id);
	public User findUserByname(String name);
	public User findUserBynameHandler(String name);
	public void insertUser(User user);
	public void deleteUser(int id);
	public Person findPersonById(long id);
	public void insertPerson(Person person);
	public Person getPersonById(long id);
	
	public Orders findOrderByid(int id);
}
