package com.erodriguessantana.bookstoremanager.dto;

import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.entity.Book;

public class ResponseBookAuthorDTO {

	private Book book;
	private Author author;

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
