package br.com.deimos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.com.deimos.dto.BookDto;
import br.com.deimos.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@QueryMapping
	public BookDto bookByName(@Argument String name) {
		
		return service.findBookByName(name);
	}
	
	@QueryMapping
	public List<BookDto> listBooks(@Argument int size, @Argument int page){
		return service.listAllBooks(size, page-1);
	}
	
	@MutationMapping
	public BookDto createBook(@Argument String name, @Argument int pageCount, @Argument String author) throws Exception {
		
		return service.createBook(name, pageCount, author);
	}
	
	@MutationMapping
	public BookDto updateBook(@Argument String oldName, @Argument String newName, @Argument Integer pageCount, @Argument String author) throws Exception {
		
		return service.updateBook(oldName, newName, pageCount, author);
	}
	
	@MutationMapping
	public BookDto deleteBook(@Argument String name) throws Exception {
		
		return service.deleteBook(name);
	}
}