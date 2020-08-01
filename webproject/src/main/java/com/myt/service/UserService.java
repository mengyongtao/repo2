package com.myt.service;

import java.util.List;

import com.myt.entity.User;

public interface UserService {
	void addUser(User user);
	List<User> queryAll();
}
