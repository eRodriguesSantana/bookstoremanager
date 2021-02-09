package com.erodriguessantana.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erodriguessantana.bookstoremanager.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
