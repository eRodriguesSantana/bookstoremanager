package com.erodriguessantana.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.MessageResponseDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public MessageResponseDTO create(Book book) {
		Book savedBook = bookRepository.save(book);
		return MessageResponseDTO.builder()
				.message("Book created with ID: " + savedBook.getId())
				.build();
	}
}
