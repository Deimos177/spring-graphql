package br.com.deimos.service;

import java.util.List;

import br.com.deimos.dto.BookDto;

public interface BookService {
	
	public BookDto findBookByName(String name);
	public BookDto createBook(String name, int pageCount, String author) throws Exception;
	public BookDto updateBook(String oldName, String newName, Integer pageCount, String author) throws Exception;
	public List<BookDto> listAllBooks(int size, int page);
	public BookDto deleteBook(String name) throws Exception;
}