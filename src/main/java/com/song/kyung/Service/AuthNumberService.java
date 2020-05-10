package com.song.kyung.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.AuthNumberMapper;
import com.song.kyung.Vo.AuthNumber;

@Service
public class AuthNumberService {
	
	@Autowired AuthNumberMapper authNumberMapper;

	public int AuthNumberAction(AuthNumber authNumber)
	{
		return authNumberMapper.AuthNumberAction(authNumber);
	}


}
