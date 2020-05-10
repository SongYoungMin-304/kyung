package com.song.kyung.Controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.song.kyung.Service.AuthNumberService;
import com.song.kyung.Vo.AuthNumber;



@RestController
public class EmailController {
	
	@Autowired
	AuthNumberService authNumberService;

	
	@RequestMapping(value = "/mailSender",method= {RequestMethod.GET}) 
	public void mailSender(@RequestParam String email) throws AddressException, MessagingException 
	{
		
		int s = email.indexOf("@");
		 
		String email_id = email.substring(0, s);
		 
		String email_domain = email.substring(s + 1);
		
		String random = numberGen(4,2);
		
		System.out.println("송아지"+email_domain);
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
		// Google일 경우 smtp.gmail.com 을 입력합니다. 
		String host = "smtp.naver.com"; 
		final String username = "dudals789"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
		final String password = "songyoungmin304"; //네이버 이메일 비밀번호를 입력해주세요. 
		int port=465; //포트번호 // 메일 내용 
		String recipient = email; //받는 사람의 메일주소를 입력해주세요. 
		String subject = "인증번호 발송"; //메일 제목 입력해주세요. 
		String body = "인증번호는 "+random+"입니다."; //메일 내용 입력해주세요. 
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 
		// SMTP 서버 정보 설정 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		//Session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		{
			String un=username; 
			String pw=password; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
			{
				return new javax.mail.PasswordAuthentication(un, pw); 
				}
			}
		);
		session.setDebug(true); //for debug 
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 
		mimeMessage.setFrom(new InternetAddress("dudals789@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. 
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
		mimeMessage.setSubject(subject); //제목셋팅 
		mimeMessage.setText(body); //내용셋팅 
		Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 
		
		
		
		
		AuthNumber authNumber = new AuthNumber();
		authNumber.setEmail(email);
		authNumber.setRandom(random);
		
		
		authNumberService.AuthNumberAction(authNumber);
		
		}
	
	
public static String numberGen(int len, int dupCd ) {
        
        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수
        
        for(int i=0;i<len;i++) {
            
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            
            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }

}
