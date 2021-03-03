package com.erodriguessantana.bookstoremanager.utilsBookDTO;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;

public class ConverterBookDtoToObject {

	public Book converterBookDtoToObject(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setName(bookDTO.getName());
		book.setPages(bookDTO.getPages());
		book.setChapters(bookDTO.getChapters());
		book.setIsbn(bookDTO.getIsbn());
		book.setBookType(bookDTO.getBookType());
		book.setPublisherName(bookDTO.getPublisherName());
		book.setIdAuthor(bookDTO.getIdAuthor());
		return book;
	}
}
