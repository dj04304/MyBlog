package com.jun.blogProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bean등록(IoC관리)
@EnableWebSecurity // 시큐리티 필터 등록
@EnableGlobalMethodSecurity (prePostEnabled = true)// 특정 주소로 접근시 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig{
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				
			.and()
				.formLogin()
				.loginPage("/auth/loginForm");
		
		return http.build();
		
	}

}
