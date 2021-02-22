package com.erodriguessantana.bookstoremanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.ResponseBookAuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findBookById(@PathVariable Long id) {
		BookDTO bookDtoId = bookService.findBookById(id);
		if(bookDtoId != null)
			return new ResponseEntity<>(bookDtoId, HttpStatus.OK);
		return new ResponseEntity<>("ID do Book informado não existe na base de dados.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/bookwithauthor/{id}")
	public ResponseEntity<?> findBookAndAuthorById(@PathVariable Long id) {
		ResponseBookAuthorDTO bookAuthorId = bookService.findByBookAuthorByID(id);
		if(bookAuthorId != null)
			return new ResponseEntity<>(bookAuthorId, HttpStatus.OK);
		return new ResponseEntity<>("ID do Book informado não existe na base de dados.", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
    public ResponseEntity<?> save(@RequestBody BookDTO bookDTO) {	
        Book bookSaved = bookService.save(bookDTO);
		return bookSaved != null 
				? new ResponseEntity<>(bookSaved, HttpStatus.CREATED) 
				: new ResponseEntity<>("ID do Author informado não existe na base de dados.", HttpStatus.NOT_FOUND);
    }
}
