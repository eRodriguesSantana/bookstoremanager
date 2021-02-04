package com.erodriguessantana.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erodriguessantana.bookstoremanager.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
