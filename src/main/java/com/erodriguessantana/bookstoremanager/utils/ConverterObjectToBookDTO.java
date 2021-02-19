package com.erodriguessantana.bookstoremanager.utils;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;

public class ConverterObjectToBookDTO {

	public BookDTO converterObjectToBookDTO(Book book) {
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
