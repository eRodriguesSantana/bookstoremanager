package com.erodriguessantana.bookstoremanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.erodriguessantana.bookstoremanager.service.PriceBook;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Book extends PriceBook {

	@ApiModelProperty(value = "Código do Book")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Nome do Book")
	@Column(nullable = false, unique = true)
	@NotBlank
	@Size(max = 200)
	private String name;
	
	@ApiModelProperty(value = "Preço do Book")
	@Column(nullable = false)
	@NotNull
	private Double price;

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
	
	@ApiModelProperty(value = "Tipo do Livro")
	@Column(name = "book_type", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private BookType bookType;

	public Book() {
	}

	public Book(Long id, String name, Double price, Integer pages, Integer chapters, String isbn, String publisherName,
			Long idAuthor, BookType bookType) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.pages = pages;
		this.chapters = chapters;
		this.isbn = isbn;
		this.publisherName = publisherName;
		this.idAuthor = idAuthor;
		this.bookType = bookType;
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
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	@Override
	public Double getDiscount() {
		if(getBookType().equals(BookType.LITERATURA))
			return 25.0;
		else if(getBookType().equals(BookType.BIOGRAFIA))
			return 15.0;
		else if(getBookType().equals(BookType.TERROR))
			return 10.0;
		else
			return 3.0;
	}
	
}
