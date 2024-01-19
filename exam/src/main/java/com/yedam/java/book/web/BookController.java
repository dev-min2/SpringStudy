package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getMainPageForm() {
		return "book/index";
	}
	
	@GetMapping("/bookList")
	public String getBookList(Model model) {
		List<BookVO> bookList = bookService.getBookList();
		
		model.addAttribute("list", bookList);
		return "book/bookList";
	}
	
	@GetMapping("/bookInsert")
	public String getBookInsertForm(Model model) {
		int nextBookNo = bookService.getNextMaxBookNo();
		model.addAttribute("bookNo", nextBookNo);
		return "book/bookInsert";
	}
	
	@PostMapping("/bookInsert")
	public String postBookControl(BookVO vo) {
		bookService.insertBook(vo);
		return "redirect:bookList";
	}
	
	@GetMapping("/bookRentStatus")
	public String getRentBookStatusControl(Model model) {
		var list = bookService.getRentBookStatus();
		model.addAttribute("list", list);
		
		return "book/bookRentalStatus";
	}
}
