package com.erodriguessantana.bookstoremanager.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.erodriguessantana.bookstoremanager.dto.AuthorDTO;
import com.erodriguessantana.bookstoremanager.entity.Author;
import com.erodriguessantana.bookstoremanager.repository.AuthorRepository;

public class ConverterToAuthorDTO {

	private AuthorRepository authorRepository;

	public ConverterToAuthorDTO(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<AuthorDTO> getAuthors() {
		return ((List<Author>) authorRepository.findAll()).stream().map(this::converterToAuthorDTO)
				.collect(Collectors.toList());
	}
	
	private AuthorDTO converterToAuthorDTO(Author author) {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setName(author.getName());
		authorDTO.setAge(author.getAge());
		
		return authorDTO;
	}
}
