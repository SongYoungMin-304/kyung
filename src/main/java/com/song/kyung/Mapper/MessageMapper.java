package com.song.kyung.Mapper;

import java.util.List;

import com.song.kyung.Vo.Message;

public interface MessageMapper {
	
	public List<Message> getMessages(String id);

}
