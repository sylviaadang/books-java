package com.sylviadang.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sylviadang.books.models.Book;
import com.sylviadang.books.services.BookService;

@RestController
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return service.allBooks();
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String description, 
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages){
		Book book = new Book(title, description, lang, numOfPages);
		return service.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = service.findBook(id);
		return book;
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book updateBook(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, description, lang, numOfPages);
        book.setId(id);
        return service.updateBook(book);
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") Long id) {
        service.deleteBook(id);
    }
}