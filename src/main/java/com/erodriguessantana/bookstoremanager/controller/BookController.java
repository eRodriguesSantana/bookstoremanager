package com.erodriguessantana.bookstoremanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erodriguessantana.bookstoremanager.dto.MessageResponseDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookRepository bookRepository;
	
	//@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody Book book) {
		Book savedBook = bookRepository.save(book);
		return MessageResponseDTO.builder()
				.message("Book created with ID: " + savedBook.getId())
				.build();
	}
}
