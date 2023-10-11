package com.jun.blogProject.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터가 필요할 때 사용
	private String content;
	
	private int count; //조회수
	
	//fetch = FetchType.EAGER => Board테이블을 Select하면 바로 user정보를 가져온다는 ManyToOne의 default이다.
	@ManyToOne(fetch = FetchType.EAGER) //Many = board, User = one (여러개의 게시글은 한명에 의해서 쓰일 수 있다.)
	@JoinColumn(name="userId")
	private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	// mappedBy는 연관관계의 주인이 아니다.(FK가 아니니 DB에 컬럼을 만들지 말라는 뜻이다.)
	// fetch = FetchType.LAZY => 필요하면 들고오고, 아니면 들고오지 않는다는 OneToMany 의 default이다.
	// 하지만 여기서는 UI를 게시글 내에 바로 댓글을 가져올 수 있게끔 하기 위해 FetchType.EAGER 을 설정하여 Board를 불러올 때마다 Select할 수 있게끔 한다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)  // 하나의 게시글(One)은 여러개의 댓글(Many)를 가질 수 있다. 
	private List<Reply> reply; //  여러개의 댓글을 가질 수 있기 때문에 List를 사용
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
	

}
