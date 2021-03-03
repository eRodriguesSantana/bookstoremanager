package com.erodriguessantana.bookstoremanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.ResponseBookAuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;
import com.erodriguessantana.bookstoremanager.utilsBookDTO.ConverterBookDtoToObject;
import com.erodriguessantana.bookstoremanager.utilsBookDTO.ConverterObjectToBookDTO;

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

	public BookDTO findBookById(Long id) {
		Book bookId = bookRepository.findById(id).orElse(null);
		if (bookId != null)
			return new ConverterObjectToBookDTO().converterObjectToBookDTO(bookId);
		return null;
	}
	
	public Book save(BookDTO bookDTO) {
		if (authorRepository.findById(bookDTO.getIdAuthor()).isPresent()) {
			Book dtoToObjectBook = new ConverterBookDtoToObject().converterBookDtoToObject(bookDTO);
			return bookRepository.save(dtoToObjectBook);
		}		
		return null;
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
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
			
	}
}
