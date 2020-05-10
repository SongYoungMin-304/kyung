package com.song.kyung.WebSocket;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/*@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
    	System.out.println("세션2:"+session.getId());
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
            System.out.println("세션들"+sessions.toString());
            
        }
        
        if (chatMessage.getType().equals(ChatMessage.MessageType.TALK)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getMessage());
        }
        
        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }
}*/
/*@Getter
@Setter
public class ChatRoom {
    private String roomId;
    private String name;
    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}*/
@Getter
@Setter
public class ChatRoom implements Serializable {
    private static final long serialVersionUID = 6494678977089006639L;
    private String roomId;
    private String name;
    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
