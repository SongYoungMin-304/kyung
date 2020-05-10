package com.song.kyung.Controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.song.kyung.Repository.ChatRoomRepository;
import com.song.kyung.Vo.ChatMessage;
import com.song.kyung.Vo.ChatMessage.MessageType;
import com.song.kyung.redis.RedisPublisher;

import lombok.RequiredArgsConstructor;

/*@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}*/

//import 생략...

@RequiredArgsConstructor
@Controller
public class ChatController {

	private final SimpMessageSendingOperations messagingTemplate;

	// 추가부분
	private final RedisPublisher redisPublisher;
	private final ChatRoomRepository chatRoomRepository;

	// REDIS 저장 부분
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@MessageMapping("/chat/message")
	public void message(ChatMessage message) throws JsonProcessingException {
		System.out.println("메세지:" + message.toString());

		if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
			message.setMessage(message.getSender() + "님이 입장하셨습니다.");

			// 추가부분
			chatRoomRepository.enterChatRoom(message.getRoomId());
		}

		// messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);

		// 추가부분

		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		
		
		if (vop.get(message.getRoomId())!=null) {

		List<ChatMessage> list = (List<ChatMessage>) vop.get(message.getRoomId());
		
		list.add(message);
		
		Collections.reverse(list);
		
		vop.set(message.getRoomId(), list);
		
		System.out.println("테스트"+list.toString());
		
		}		
		
		else {
			List<ChatMessage> list = new LinkedList();
			list.add(message);
			vop.set(message.getRoomId(), list);
		}
		
		
		
		
		/*for(ChatMessage chat: list) {
			System.out.println("체킷"+chat.getMessage());
		}*/
		
		/*System.out.println("송영민"+messagew.getMessage());
		*/
		//System.out.println(vop.get("chatMessage"));
		

		
		redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
	}

	@MessageMapping("/chat/song")
	@SendTo("/sub/chat/room")
	public ChatMessage message1(ChatMessage message) {
		System.out.println("메세지2:" + message.toString());

		if (ChatMessage.MessageType.ENTER.equals(message.getType()))
			message.setMessage(message.getSender() + "님이 입장하셨습니다.");
		// messagingTemplate.convertAndSend("/sub/chat/room", message);
		return message;
	}

}