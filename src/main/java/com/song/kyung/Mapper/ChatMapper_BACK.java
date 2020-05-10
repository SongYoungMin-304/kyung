package com.song.kyung.Mapper;

import java.util.List;

import com.song.kyung.Vo.HelloMessage;

public interface ChatMapper_BACK {
	
	public int addChatAction(HelloMessage helloMessage);
	
	public List<HelloMessage> getChats();

}
