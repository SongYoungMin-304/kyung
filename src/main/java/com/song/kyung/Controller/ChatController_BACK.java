package com.song.kyung.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.kyung.Service.ChatService_BACK;
import com.song.kyung.Vo.HelloMessage;

@Controller
public class ChatController_BACK {

	@Autowired ChatService_BACK chatService;
	
	@RequestMapping("/song")
	public String song(Principal principal, Model model)
	{
		model.addAttribute("user", principal.getName());
		
		System.out.println("test2");
		return "song";
	}
	
	@MessageMapping("hello")
	@SendTo("/chat/hello")
	public HelloMessage hello(HelloMessage message) throws Exception
	{
		System.out.println("test1");
		Thread.sleep(100);
		System.out.println("a"+message.getName());
		System.out.println("b"+message.getContents());
		System.out.println("c"+message.getSend_date());
		
		
		return message;
	}
	
	@MessageMapping("bye")
	@SendTo("/chat/bye")
	public HelloMessage bye(HelloMessage message) throws Exception
	{

		System.out.println("test3");
		Thread.sleep(100);
		return message;
	}
	
	@MessageMapping("detail")
	@SendTo("/chat/detail")
	public HelloMessage detail(HelloMessage message) throws Exception
	{
		Thread.sleep(100);
		System.out.println("내용"+message.getContents());
		System.out.println("내용"+message.getName());
		
		System.out.println("test4");
		message.setSend_date(new Date());
		message.setChannel_type("total");
		
		chatService.addChatAction(message);
		
		return message;
	}
	@RequestMapping(value ="/getChats", method= {RequestMethod.GET})
	@ResponseBody
	public List<HelloMessage> getChats()
	{
		
		List<HelloMessage> messages = chatService.getChats();
		System.out.println("민영송"+messages.get(0).getContents());
		return messages;
	}
	
	@RequestMapping("/top")
	public String top()
	{
		return "sidebar/top";
	}
	

}
