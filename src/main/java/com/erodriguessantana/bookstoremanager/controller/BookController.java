package com.erodriguessantana.bookstoremanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erodriguessantana.bookstoremanager.dto.MessageResponseDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookService bookService;
	
	//@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody Book book) {
		return bookService.create(book);
	}

}
