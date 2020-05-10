package com.song.kyung.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.song.kyung.Service.MessageService;
import com.song.kyung.Vo.Message;

@Controller
public class MessageController {
	
	   
	   @Autowired MessageService messageService;
	   
	   @RequestMapping(value="/getMessages",method= {RequestMethod.GET})
	   public List<Message> getMessages(Principal principal) throws Exception
	   {
	      List<Message> message = messageService.getMessages(principal.getName());
	      
	      return message;
	   }
	   

}
