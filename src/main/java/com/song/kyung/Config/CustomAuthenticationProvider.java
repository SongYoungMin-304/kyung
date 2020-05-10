package com.song.kyung.Config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.song.kyung.Service.UserService;
import com.song.kyung.Vo.User;




@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) {

		
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		System.out.println("인증 Provider 시작");
		
		UserDetails user = (UserDetails) service.loadUserByUsername(username);
		
		
	/*	if(!matchPassword(password+"!", user.getPassword())) {
            throw new BadCredentialsException(username);
        }*/
		
		
		if(!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
			System.out.println("비밀번호 불일치");
            throw new BadCredentialsException(username);
        }
 
        if(!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }
        
         System.out.println("인증 Provider 마감");
		return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		 return authentication.equals(UsernamePasswordAuthenticationToken.class);
		//return false;
	}
	
	  private boolean matchPassword(String loginPwd, String password) {
	        return loginPwd.equals(password);
	    }


}
