package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookRentJoinVO;
import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> selectBookList();
	public int selectNextMaxBookNo();
	public int insertBook(BookVO vo);
	public List<BookRentJoinVO> selectRentBookStatus();
}
