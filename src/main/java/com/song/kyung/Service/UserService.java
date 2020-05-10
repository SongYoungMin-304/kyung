package com.song.kyung.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.UserMapper;
import com.song.kyung.Vo.User;

@Service
public class UserService {

	@Autowired UserMapper userMapper;

	public int addUserAction(User user)
	{
		return userMapper.addUserAction(user);
	}
	
	public User getUserByUserId(String id)
	{
		return userMapper.getUserByUserId(id);
	}
	
	public int getCountUserByUserId(String id)
	{
		return userMapper.getCountUserByUserId(id);
	}
	
	public int getFailCountByUserId(String id)
	{
		return userMapper.getFailCountByUserId(id);
	}
	
	public int addFailCountByUserId(String id)
	{
		return userMapper.addFailCountByUserId(id);
	}
	
	public int initFailCountByUserId(String id)
	{
		return userMapper.initFailCountByUserId(id);
	}
	
	public int lockByUserId(String id)
	{
		return userMapper.lockByUserId(id);
	}
	
	public String selectLockByUserId(String id)
	{
		return userMapper.selectLockByUserId(id);
	}
	
	public List<User> getUsers()
	{
		return userMapper.getUsers();
	}
	
	

	
}
