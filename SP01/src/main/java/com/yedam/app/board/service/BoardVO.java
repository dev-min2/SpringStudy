package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title;
	private String contents;
	private String writer;
	
	// <input type="date">
	@DateTimeFormat(pattern= "yyyy-MM-dd") // 특정포맷만 인정하겠다는 어노테이션
	private Date regdate;
	private Date updatedate; // yyyy/MM/dd
	private String image;
}
