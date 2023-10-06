package com.jun.blogProject.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jun.blogProject.model.User;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고, 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 정보에 저장을 해준다.
public class PrincipalDetail implements UserDetails{

	private User user; // 객체를 품고있는 것 (컴포지션)
	
	//principalDetailService에서 받아온 user의 정보를 담아오기 위해 생성자를 생성
	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴해준다. (true 만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 잡겨 있지 않았는지 리턴해준다. (true 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호의 반료 여부를 리턴(true 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 활성화인지 리턴(true 활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<GrantedAuthority>();
		
		collectors.add(() -> {
			return "ROLE_" + user.getRole();
		});
		
		return collectors;
	}
	
}


	/*
	 * collectors.add(new GrantedAuthority() {
	 * 
	 * @Override public String getAuthority() { return "ROLE_" + user.getRole(); }
	 * });
	 */


