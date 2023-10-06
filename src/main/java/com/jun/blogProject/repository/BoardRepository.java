package com.jun.blogProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.blogProject.model.Board;
import com.jun.blogProject.model.User;

//DAO
// @Repository 생략 가능
public interface BoardRepository extends JpaRepository<Board, Integer>{
	

}
