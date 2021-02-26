package com.erodriguessantana.bookstoremanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Book {

	@ApiModelProperty(value = "Código do Book")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Nome do Book")
	@Column(nullable = false, unique = true)
	@NotBlank
	@Size(max = 200)
	private String name;

	@ApiModelProperty(value = "Quantidade de páginas do Book")
	@Column(nullable = false)
	@NotNull
	private Integer pages;

	@ApiModelProperty(value = "Quantidade de capítulos do Book")
	@Column(nullable = false)
	@NotNull
	private Integer chapters;

	@ApiModelProperty(value = "ISBN do Book")
	@Column(nullable = false)
	@NotBlank
	@Size(max = 200)
	private String isbn;

	@ApiModelProperty(value = "Nome da publicadora do Book")
	@Column(name = "publisher_name", nullable = false)
	@NotBlank
	@Size(max = 200)
	private String publisherName;

	@ApiModelProperty(value = "ID do Author do Book")
	@Column(name = "id_author", nullable = false)
	@NotNull
	private Long idAuthor;

	public Book() {
	}

	public Book(Long id, String name, Integer pages, Integer chapters, String isbn, String publisherName,
			Long idAuthor) {
		super();
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
