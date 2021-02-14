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
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDTO bookDTO) {
        Book bookSaved = bookService.save(bookDTO);
        if(bookSaved != null)
        	return new ResponseEntity<>(bookSaved, HttpStatus.CREATED);
        return new ResponseEntity<>(bookSaved, HttpStatus.NOT_FOUND);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
		BookDTO bookId = bookService.findById(id);
		if(bookId != null)
			return new ResponseEntity<>(bookId, HttpStatus.OK);
		return new ResponseEntity<>(bookId, HttpStatus.NOT_FOUND);
	}

}
