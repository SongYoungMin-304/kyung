package com.song.kyung.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.MainMapper;
import com.song.kyung.Vo.test;

@Service
public class MainService {
	
	@Autowired 
	MainMapper mainMapper;
	
	public List<test> dbTest()
	{
		return mainMapper.dbTest();
	}

}
