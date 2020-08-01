package com.myt.serviceImpl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.myt.entity.User;
import com.myt.service.UserService;

public class UserServiceImpl extends JdbcDaoSupport implements UserService {

	@Override
	public void addUser(User user) {
		this.getJdbcTemplate().update("insert into t_user (username,userpwd) values(?,?)", user.getUserName(),user.getUserPwd());
	}

	@Override
	public List<User> queryAll() {
		return this.getJdbcTemplate().query("select * from t_user", BeanPropertyRowMapper.newInstance(User.class));
	}

}
