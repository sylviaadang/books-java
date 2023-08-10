package com.sylviadang.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sylviadang.books.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
}
