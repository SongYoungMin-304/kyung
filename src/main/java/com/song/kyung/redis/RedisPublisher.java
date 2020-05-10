package com.song.kyung.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.song.kyung.Vo.ChatMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    public void publish(ChannelTopic topic, ChatMessage message) {
    	System.out.println("topic"+topic);
    	System.out.println("메세징"+message);
    	
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}