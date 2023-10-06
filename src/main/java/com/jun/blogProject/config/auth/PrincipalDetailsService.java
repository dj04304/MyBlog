package com.jun.blogProject.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	//password 부분은 Spring 이 알아서 처리해주기 떄문에 Username이 DB에 있는지 확인해주면 된다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username)
				.orElseThrow(() -> {
					return new UsernameNotFoundException("The user could not be found.: " + username);
							
				});
		
		
		return new PrincipalDetail(userEntity); //Security 세션에 user 정보가 저장된다.
		
		/*
		 * if(username != null) { return new PrincipalDetail(userEntity); //Security 세션에
		 * user 정보가 저장된다. }
		 * 
		 * return null;
		 */
		
	}
}
