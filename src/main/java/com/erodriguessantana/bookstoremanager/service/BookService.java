package com.erodriguessantana.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Book save(BookDTO bookDTO) {
		if(authorRepository.findById(bookDTO.getIdAuthor()).isPresent())
			return bookRepository.save(bookDTO.converterToObject());
		return null;
	}

	public BookDTO findById(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);
		if(bookId != null)
			return new Book().converterToDTO(bookId);
		return null;
	}
}
