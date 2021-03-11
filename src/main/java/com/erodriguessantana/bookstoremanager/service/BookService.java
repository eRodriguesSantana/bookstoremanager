package com.erodriguessantana.bookstoremanager.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.dto.ResponseBookAuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;
import com.erodriguessantana.bookstoremanager.service.impl.IBook;
import com.erodriguessantana.bookstoremanager.utilsBookDTO.ConverterBookDtoToObject;

@Service
public class BookService implements IBook{

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

	public ResponseEntity<?> save(BookDTO bookDTO) {
		try {
			if (authorRepository.findById(bookDTO.getIdAuthor()).isPresent()) {
				return new ResponseEntity<>(
						bookRepository.save(new ConverterBookDtoToObject().converterBookDtoToObject(bookDTO)),
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("ID do Author informado não existe na base de dados.",
						HttpStatus.NOT_FOUND);
			}

		} catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>("Já existe um Book com esse nome.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> update(BookDTO bookDTO, Long id) {
		try {
			if (findBookById(id) != null) {
				Book bookSaved = bookRepository.findById(id).orElse(null);

				if ((bookSaved != null && bookSaved.getId() == id)
						&& (authorRepository.findById(bookDTO.getIdAuthor()).isPresent())) {
					bookSaved.setId(id);
					bookSaved.setName(bookDTO.getName());
					bookSaved.setPrice(bookDTO.getPrice());
					bookSaved.setPages(bookDTO.getPages());
					bookSaved.setChapters(bookDTO.getChapters());
					bookSaved.setIsbn(bookDTO.getIsbn());
					bookSaved.setBookType(bookDTO.getBookType());
					bookSaved.setPublisherName(bookDTO.getPublisherName());
					bookSaved.setIdAuthor(bookDTO.getIdAuthor());

					return new ResponseEntity<>(bookRepository.save(bookSaved), HttpStatus.CREATED);
				}
				return new ResponseEntity<>("ID do Book ou ID do Author não existe.", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("ID informado para atualização não existe na base de dados.",
					HttpStatus.NOT_FOUND);
		} catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>("Já existe um Book com esse nome: " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
