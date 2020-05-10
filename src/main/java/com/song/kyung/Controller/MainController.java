package com.song.kyung.Controller;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.song.kyung.Service.MainService;
import com.song.kyung.Vo.test;

@Controller
public class MainController {

	@Autowired
	MainService mainService;

	@RequestMapping("/login")
	public String login()
	
	{
		ModelAndView mv = new ModelAndView("login");
		return "login";
	}

	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}

	@RequestMapping("/main")
	public String main() {
		return "table";
	}

	@RequestMapping("/table")
	public String showTable() {
		return "table";
	}

	@RequestMapping("/dbTest")
	public int dbTest() {
		List<test> test = mainService.dbTest();
		return test.get(0).getAge();
	}
	
	@RequestMapping("/kyung")
	public String test() {
		return "chat/roomdetail";
	}
	

}
