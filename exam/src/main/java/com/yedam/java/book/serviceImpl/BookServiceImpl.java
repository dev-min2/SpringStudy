package com.yedam.java.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookRentJoinVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<BookVO> getBookList() {
		// TODO Auto-generated method stub
		return bookMapper.selectBookList();
	}

	@Override
	public int getNextMaxBookNo() {
		// TODO Auto-generated method stub
		return bookMapper.selectNextMaxBookNo();
	}

	@Override
	public boolean insertBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.insertBook(vo) > 0 ? true : false;
	}

	@Override
	public List<BookRentJoinVO> getRentBookStatus() {
		// TODO Auto-generated method stub
		return bookMapper.selectRentBookStatus();
	}

}
