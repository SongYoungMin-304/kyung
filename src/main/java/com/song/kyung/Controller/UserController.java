package com.song.kyung.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.song.kyung.Service.MessageService;
import com.song.kyung.Service.UserService;
import com.song.kyung.Vo.Message;
import com.song.kyung.Vo.User;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;
	


	@RequestMapping(value = "/addUserAction", method = { RequestMethod.POST, RequestMethod.GET })
	public String addUserAction(@ModelAttribute("User") User user) throws Exception {
		String password = user.getPassword();
		System.out.println("회원가입 비밀번호:"+password);
		password = new BCryptPasswordEncoder().encode(password);
		System.out.println("회원가입 암호화 비밀번호:"+password);
		user.setPassword(password);
		userService.addUserAction(user);
		return "redirect:/login";
	}

	// 로그인 부분
	@RequestMapping(value = "/getUserByUserId/{id}")
	public User getUserByUserId(@PathVariable String id) {
		User user = userService.getUserByUserId(id);
		System.out.println("송채린" + user.getPassword());
		return user;
	}

	@RequestMapping(value = "/getUsers")
	public String getUsers(Model model, Principal principal) {
		List<User> users = userService.getUsers();
		
		System.out.println("이메일"+users.get(0).getEmail());
		model.addAttribute("users",users);

		List<Message> messages = messageService.getMessages(principal.getName());

		model.addAttribute("messages", messages);

		return "users";
	}

}
