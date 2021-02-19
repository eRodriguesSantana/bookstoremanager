package com.erodriguessantana.bookstoremanager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.AuthorDTO;
import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.ResponseBookAuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;
import com.erodriguessantana.bookstoremanager.utils.ConverterBookDtoToObject;

@Service
public class BookService {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Book save(BookDTO bookDTO) {
		if (authorRepository.findById(bookDTO.getIdAuthor()).isPresent()) {
			Book dtoToObjectBook = new ConverterBookDtoToObject().converterBookDtoToObject(bookDTO);
			return bookRepository.save(dtoToObjectBook);
		}		
		return null;
	}

	public BookDTO findBookById(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);
		if (bookId != null)
			return null;//new Book().converterToDTO(bookId);
		return null;
	}

	public AuthorDTO findAuthorById(Long id) {
		Author authorId = authorRepository.findById(id).orElse(null);
		if (authorId != null)
			return new Author().converterToDTO(authorId);
		return null;
	}

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	public ResponseBookAuthorDTO findByBookAuthorByID(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);
		Author authorId = authorRepository.findById(bookId.getIdAuthor()).orElse(null);
		if (bookId != null && authorId != null) {
			ResponseBookAuthorDTO responseBookAuthorDTO = new ResponseBookAuthorDTO();
			responseBookAuthorDTO.setBook(bookId);
			responseBookAuthorDTO.setAuthor(authorId);

			return responseBookAuthorDTO;
		}

		return null;
	}
}
