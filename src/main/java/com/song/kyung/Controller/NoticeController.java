package com.song.kyung.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.song.kyung.Service.MessageService;
import com.song.kyung.Service.NoticeService;
import com.song.kyung.Vo.Message;
import com.song.kyung.Vo.Notice;

@Controller
public class NoticeController {
   
   @Autowired NoticeService noticeService;
   @Autowired MessageService messageService;
   
   @RequestMapping(value="/addNoticeAction",method= {RequestMethod.POST})
   public String addNoticeAction(@ModelAttribute("Notice")Notice notice,Principal principal) throws Exception
   {
      
      if(principal.getName().equals(null))
      {
    	  notice.setAuthor("song"); 
      }
      else {
    	  notice.setAuthor(principal.getName());
      }
      
      int result = noticeService.addNoticeAction(notice);
      return "redirect:/notice";
   }
   
   @RequestMapping(value="/addNotice",method= {RequestMethod.GET})
   public String addNotice()
   {
      return "addNotice";
   }
   
   @RequestMapping("/notice")
   public String showNotice(Model model,Principal principal)
   {
      List<Notice> notices = noticeService.getNotices();
      model.addAttribute("notices", notices);      
      
      List<Message> messages = messageService.getMessages(principal.getName());
      
      model.addAttribute("messages", messages);      
      
      return "notice";
   }
   
   @RequestMapping("/getNoticeById/{id}")
   public String getNoticeById(@PathVariable int id,Model model, Principal principal )
   {
	  Notice notice = noticeService.getNoticeById(id);
	  noticeService.addReadCount(id);
	   model.addAttribute("notice",notice);
	   model.addAttribute("author",principal.getName());
	  return "noticeById";
   }
   
   @RequestMapping("/deleteNoticeById/{id}")
   public String deleteNoticeById(@PathVariable int id)
   {
	   int deleteResult = noticeService.deleteNoticeById(id);
	   return "redirect:/notice";
   }
   
   @RequestMapping(value="/getNotices",method= {RequestMethod.GET})
   public List<Notice> addNoticeAction() throws Exception
   {
      List<Notice> notices = noticeService.getNotices();     

      return notices;
   }
   
   @RequestMapping(value="/setNoticeById" ,method= {RequestMethod.POST})
   public String setNoticeById(@ModelAttribute("Notice")Notice notice) throws Exception
   {
	   System.out.println("song");
	   
	   System.out.println("song2"+notice.getId());
	   System.out.println("song3"+notice.getSubject());
	   System.out.println("song4"+notice.getContent());
	   
	   
      noticeService.setNoticeById(notice);
      System.out.println("song12");
      return "redirect:/getNoticeById/"+notice.getId();
   }
   
   @RequestMapping(value="/setNotice/{id}" ,method= {RequestMethod.GET})
   public String setNotice(@PathVariable int id,Model model) throws Exception
   {
	   Notice notice = noticeService.getNoticeById(id);
	   model.addAttribute("notice",notice);
	   
      return "setNoticeById";
   }
   
   
   
   
   
   

}