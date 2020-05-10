package com.song.kyung.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.ChatMapper_BACK;
import com.song.kyung.Vo.HelloMessage;

@Service
public class ChatService_BACK {
	
	@Autowired 
	ChatMapper_BACK chatMapper;
	
	public int addChatAction(HelloMessage helloMessage)
	{
		return chatMapper.addChatAction(helloMessage);
	}
	
	public List<HelloMessage> getChats()
	{
		return chatMapper.getChats();
	}

}
