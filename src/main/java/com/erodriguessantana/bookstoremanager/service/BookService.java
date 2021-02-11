package com.erodriguessantana.bookstoremanager.service;

import org.springframework.stereotype.Service;

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

	public Book save(Book book) {
		if(authorRepository.findById(book.getIdAuthor()).isPresent())
			return bookRepository.save(book);
		return null;
	}
}
