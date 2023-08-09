package com.jun.blogProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.blogProject.model.User;

//DAO
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
