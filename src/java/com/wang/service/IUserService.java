package com.wang.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wang.entity.User;

import java.util.List;

public interface IUserService{
	public List<User> selectAll();

	public int insert(User user);

	public int updateByPrimaryKeySelective(User user);

	public int delete(User user);

	public User selectOne(User user);
}
