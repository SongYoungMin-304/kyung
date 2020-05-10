package com.song.kyung.Config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.song.kyung.MyInterceptor;
import com.song.kyung.Config.CustomAuthenticationProvider;
import com.song.kyung.Service.UserService;



@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		// 아이디 = manager 비밀번호 = 1111 로 로그인 되게 처리

		// auth.inMemoryAuthentication() .withUser("manager") .password("{noop}1111")
		// .roles("MANAGER");
		auth.authenticationProvider(customAuthenticationProvider);
		// auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

				.csrf().disable().formLogin().loginPage("/login") // 로그인 시도 시에 가는 페이지 파라미터 username , password action =
																	// /login 으로 처리해야한다.
				.permitAll().successHandler(successHandler()).failureHandler(failHandler())
				.usernameParameter("user_name") // username 파라미터 변수 세팅
				.passwordParameter("pass_word") // password 파라미터 변수 세팅
				// .loginProcessingUrl("/loginKyung") // 로그인 처리 (post방식) 으로 보낼 url
				.and().authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**", "/scss/**", "/vendor/**", "/resource/**").permitAll()
				.antMatchers("/regist").permitAll().antMatchers("/mailSender/*").permitAll().antMatchers("/mailSender")
				.permitAll().antMatchers("/addUserAction").permitAll().antMatchers("/api/*").permitAll()

				// css , x-javascript, img 파일 로그인 없이도 접근가능

				// 위에 것을 제외한 나머지 Url는 인증 필요

				.anyRequest()
				//.authenticated();
		 .permitAll();
		// .permitAll();

		// .access("hasAuthority('ADMIN_USER')");

		// 로그아웃 설정

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

		// http.authenticationProvider(customAuthenticationProvider);

	}

	// 실패 핸들러

	@Bean
	public AuthenticationFailureHandler failHandler() {
		return new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {

				System.out.println("실패핸들러 출력");
				String id = request.getParameter("user_name");
				

				String checkBox = request.getParameter("checkBox");
				System.out.println("체크 박스1:"+checkBox);

				System.out.println("id" + id);

				int existYN = userService.getCountUserByUserId(id);
				System.out.println("existYn:" + existYN);

				if (existYN != 0) {
					userService.addFailCountByUserId(id);

					String lockYN = userService.selectLockByUserId(id);
					if (lockYN.equals("Y")) {
						request.setAttribute("error", "아이디가 잠겼습니다.");
						// request.getRequestDispatcher("/login").forward(request, response);
					}

					int count = userService.getFailCountByUserId(id);
					System.out.println("숫자:" + count);
					if (count >= 5) {
						request.setAttribute("error", "아이디가 잠겼습니다.");
						userService.lockByUserId(id);
					} else {
						request.setAttribute("error", count + "회 비밀번호 오류");
					} // request.getRequestDispatcher("/login").forward(request, response);
				} else {
					request.setAttribute("error", "존재하지 않는 사용자 입니다.");
				}

				request.getRequestDispatcher("/login").forward(request, response);

				// response.sendRedirect("/login/error");
			}

		};

	}

	// 성공 핸들러

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// TODO Auto-generated method stub
				String checkBox = request.getParameter("checkBox");
				System.out.println("체크 박스2:"+checkBox);
				String id = request.getParameter("username");
				userService.initFailCountByUserId(id);
				response.sendRedirect("/notice");
			}

		};

	}
}
