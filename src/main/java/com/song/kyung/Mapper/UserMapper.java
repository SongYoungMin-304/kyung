package com.song.kyung.Mapper;

import java.util.List;

import com.song.kyung.Vo.User;

public interface UserMapper {
	public int addUserAction(User user);
	
	public User getUserByUserId(String id);
	
	public int getCountUserByUserId(String id);
	
	public int getFailCountByUserId(String id);
	
	public int addFailCountByUserId(String id);
	
	public int initFailCountByUserId(String id);
	
	public int lockByUserId(String id);
	
	public String selectLockByUserId(String id);
	
	public List<User> getUsers();
}
