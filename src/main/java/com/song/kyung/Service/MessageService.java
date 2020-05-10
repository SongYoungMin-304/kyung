package com.song.kyung.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.MessageMapper;
import com.song.kyung.Vo.Message;

@Service
public class MessageService {
	
	@Autowired 
	MessageMapper messageMapper;
	
	public List<Message> getMessages(String id)
	{
		return messageMapper.getMessages(id);
	}

}
