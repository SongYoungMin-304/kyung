/*package com.song.kyung;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.song.kyung.Vo.Account;
import com.song.kyung.Vo.AccountRepository;

@Component
public class RedisRunner implements ApplicationRunner{

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		ValueOperations<String, String> value = redisTemplate.opsForValue();
		value.set("song","young");
		
		Account account = new Account();
		account.setEmail("dudals789@naver.com");
		account.setUsername("youngmin");
		
		accountRepository.save(account);
		
		Optional<Account> byId = accountRepository.findById(account.getId());
		System.out.println(byId.get().getUsername());
		System.out.println(byId.get().getEmail());
		
	}
	

}
*/