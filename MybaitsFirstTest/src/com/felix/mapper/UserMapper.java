package com.felix.mapper;

import java.util.List;

import com.felix.pojo.User;

public interface UserMapper {
	public User findUserById(int id);
	public List<User> findUserList();
}
