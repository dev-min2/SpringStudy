package com.yedam.java.book.service;

import lombok.Data;

@Data
public class BookRentJoinVO {
	private int bookNo;
	private String bookName;
	private int allPrice;
	private int allCount;
}
