package com.sylviadang.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sylviadang.books.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		model.addAttribute("book", service.findBook(bookId));
		return "show.jsp";
	}
	
}
