package com.erodriguessantana.bookstoremanager.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;

public interface IBook {

	public List<Book> getAll();
	
	public ResponseEntity<?> findBookById(Long id);
	
	public ResponseEntity<?> save(BookDTO bookDTO);
	
	public ResponseEntity<?> update(BookDTO bookDTO, Long id);
	
	public ResponseEntity<?> findByBookAuthorByID(Long id);
	
	public void delete(Long id);
}
