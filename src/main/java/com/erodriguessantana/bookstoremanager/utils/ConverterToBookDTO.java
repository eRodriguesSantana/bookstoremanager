package com.erodriguessantana.bookstoremanager.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.repository.BookRepository;

public class ConverterToBookDTO {

	private BookRepository bookRepository;

	public ConverterToBookDTO(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<BookDTO> getBooks() {
		return ((List<Book>) bookRepository.findAll()).stream().map(this::converterToBookDTO)
				.collect(Collectors.toList());
	}

	private BookDTO converterToBookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setName(book.getName());
		bookDTO.setPages(book.getPages());
		bookDTO.setChapters(book.getChapters());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setPublisherName(book.getPublisherName());
		bookDTO.setIdAuthor(book.getIdAuthor());
		return bookDTO;
	}
}
