package com.erodriguessantana.bookstoremanager.dto;

import com.erodriguessantana.bookstoremanager.entity.BookType;

import io.swagger.annotations.ApiModelProperty;

public class BookDTO {

	@ApiModelProperty(value = "Código do Book")
	private Long id;
	
	@ApiModelProperty(value = "Nome do Book")
	private String name;
	
	@ApiModelProperty(value = "Quantidade de páginas do Book")
	private Integer pages;
	
	@ApiModelProperty(value = "Quantidade de capítulos do Book")
	private Integer chapters;
	
	@ApiModelProperty(value = "ISBN do Book")
	private String isbn;
	
	@ApiModelProperty(value = "Nome da publicadora do Book")
	private String publisherName;
	
	@ApiModelProperty(value = "ID do Author do Book")
	private Long idAuthor;
	
	@ApiModelProperty(value = "Tipo do Livro")
	private BookType bookType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getChapters() {
		return chapters;
	}

	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
