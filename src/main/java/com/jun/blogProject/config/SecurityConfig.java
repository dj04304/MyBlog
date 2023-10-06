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
			.csrf().disable() // csrf 토큰 비활성화 
			.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/img/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인함.
				.defaultSuccessUrl("/");
		
		return http.build();
		
	}

}
