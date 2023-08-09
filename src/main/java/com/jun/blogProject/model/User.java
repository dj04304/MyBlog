package com.jun.blogProject.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA => User Class Table Auto Increment
@Data
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert //insert 할 때 null 값을 제외하고 넣어준다. (role 의 기본값을 "user"로 할 수 있다.)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 넘버링 전략을 따라간다. (auto-increment)
	private int id; //auto-increment
	
	@Column(nullable = false, length = 30)
	private String username; // id
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING) //DB는 RoleType이란 것이 없기 때문에 @Enumerated 가 필요하다.
	private RoleType role; //Enum을 쓰는게 좋다. Enum을 사용하면 String으로 오타의 위험이 아닌, 범주를 정해서 설정할 수 있다.// admin, user, manager (권한)
	
	@CreationTimestamp // 시간이 자동으로 입력 (회원가입시 언제 가입했는지 알려줌)
	private Timestamp createDate;
}
