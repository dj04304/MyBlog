package com.jun.blogProject.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // JPA => User Class Table Auto Increment
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
	
	@ColumnDefault("'user'")
	private String role; //Enum을 쓰는게 좋다. Enum을 사용하면 String으로 오타의 위험이 아닌, 범주를 정해서 설정할 수 있다.// admin, user, manager (권한)
	
	@CreationTimestamp // 시간이 자동으로 입력 (회원가입시 언제 가입했는지 알려줌)
	private Timestamp createDate;
}
