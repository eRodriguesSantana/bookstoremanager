package com.erodriguessantana.bookstoremanager.utilsBookDTO;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;

public class ConverterObjectToBookDTO {

	public BookDTO converterObjectToBookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setName(book.getName());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setPages(book.getPages());
		bookDTO.setChapters(book.getChapters());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setBookType(book.getBookType());
		bookDTO.setPublisherName(book.getPublisherName());
		bookDTO.setIdAuthor(book.getIdAuthor());
		return bookDTO;
	}
}
