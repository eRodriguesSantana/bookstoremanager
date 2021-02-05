package com.erodriguessantana.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.MessageResponseDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public MessageResponseDTO create(BookDTO bookDTO) {
		Book bookToSave = Book.builder().build();
		
		Book savedBook = bookRepository.save(bookToSave);
		return MessageResponseDTO.builder()
				.message("Book created with ID: " + savedBook.getId())
				.build();
	}
}
