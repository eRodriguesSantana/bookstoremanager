package com.erodriguessantana.bookstoremanager.dto;

import javax.validation.constraints.NotNull;

import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;

public class ResponseBookAuthorDTO {

	@NotNull
	private Book book;

	@NotNull
	private Author author;

	public ResponseBookAuthorDTO() {
	}

	public ResponseBookAuthorDTO(Book book, Author author) {
		this.book = book;
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}	
}
