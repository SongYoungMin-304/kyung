package com.song.kyung.Config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.song.kyung.Service.UserService;
import com.song.kyung.Vo.User;

@Service
public class UserImplService implements UserDetailsService{
	
	@Autowired
    UserService service;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	 @Override
     public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException
     {
           UserDetails userDetails=null;
           User user = new User();
           try {
                  user = service.getUserByUserId(id);
           } catch (Exception e) {
               
                  // TODO Auto-generated catch block
                  e.printStackTrace();
           }
           
           
              
           List<GrantedAuthority> authorities = new ArrayList<>();
           authorities.add(new SimpleGrantedAuthority(user.getRole()));
           userDetails = new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), authorities);
           
           return userDetails;
     }

}
