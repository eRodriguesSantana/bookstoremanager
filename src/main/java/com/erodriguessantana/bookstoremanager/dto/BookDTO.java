package com.erodriguessantana.bookstoremanager.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookDTO {

	private Long id;

	@NotBlank
	@Size(max = 200)
	private String name;

	@NotNull
	private Integer pages;

	@NotNull
	private Integer chapters;

	@NotBlank
	@Size(max = 200)
	private String isbn;

	@NotBlank
	@Size(max = 200)
	private String publisherName;

	@NotNull
	private Long idAuthor;

	public BookDTO() {
	}

	public BookDTO(Long id, String name, Integer pages, Integer chapters, String isbn, String publisherName,
			Long idAuthor) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.chapters = chapters;
		this.isbn = isbn;
		this.publisherName = publisherName;
		this.idAuthor = idAuthor;
	}

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
}
