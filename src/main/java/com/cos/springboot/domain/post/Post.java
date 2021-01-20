package com.cos.springboot.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //int id를 각자 데이터베이스 정체성에 맞는 전략으로 생성
	private int id;
	private String title;
	private String content;
	@ColumnDefault(value="0")
	private int readCount; //Dialect
}
