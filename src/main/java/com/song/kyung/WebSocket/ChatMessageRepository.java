package com.song.kyung.WebSocket;

import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository  extends CrudRepository<ChatMessage, String> {

}
