package com.jun.blogProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.blogProject.model.User;

//DAO
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);


}




//JPA Naming 쿼리 -> 실제로 없는 함수이지만 직접 만들어주고 쿼리를 실행함

//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String passowrd);

// 역할: SELECT * FROM user WHERE username = ?1 AND password = ?2;
//	User findByUsernameAndPassword(String username, String password); 
