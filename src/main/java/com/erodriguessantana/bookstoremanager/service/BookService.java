package com.erodriguessantana.bookstoremanager.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.ResponseBookAuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;
import com.erodriguessantana.bookstoremanager.utilsBookDTO.ConverterBookDtoToObject;

@Service
public class BookService {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	public ResponseEntity<?> findBookById(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);
		if (bookId != null)
			return new ResponseEntity<>(bookId, HttpStatus.OK);
		return new ResponseEntity<>("ID do Book informado não existe na base de dados.", HttpStatus.NOT_FOUND);
	}

	public Book save(BookDTO bookDTO) {
		if (authorRepository.findById(bookDTO.getIdAuthor()).isPresent()) {
			Book dtoToObjectBook = new ConverterBookDtoToObject().converterBookDtoToObject(bookDTO);
			return bookRepository.save(dtoToObjectBook);
		}
		return null;
	}

	public ResponseEntity<?> findByBookAuthorByID(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);

		if (bookId != null) {
			Author authorId = authorRepository.findById(bookId.getIdAuthor()).orElse(null);
			ResponseBookAuthorDTO responseBookAuthorDTO = new ResponseBookAuthorDTO();
			responseBookAuthorDTO.setBook(bookId);
			responseBookAuthorDTO.setAuthor(authorId);

			return new ResponseEntity<>(responseBookAuthorDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>("ID do Book informado não existe na base de dados.", HttpStatus.NOT_FOUND);

	}

	public void delete(Long id) {
		bookRepository.deleteById(id);

	}
}
