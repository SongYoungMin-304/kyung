package com.song.kyung.Repository;

import org.springframework.data.repository.CrudRepository;

import com.song.kyung.Vo.ChatMessage;

public interface ChatMessageRepository  extends CrudRepository<ChatMessage, String> {

}
