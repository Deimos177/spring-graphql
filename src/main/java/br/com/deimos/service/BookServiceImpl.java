package br.com.deimos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.deimos.dto.BookDto;
import br.com.deimos.entity.BookEntity;
import br.com.deimos.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	@Override
	public BookDto findBookByName(String name) {

		BookEntity book = repository.findBookByName(name);

		if (Objects.isNull(book))
			return null;

		return new BookDto(book.getId(), book.getName(), book.getPageCount(), book.getAuthor());
	}

	@Override
	public BookDto createBook(String name, int pageCount, String author) throws Exception {

		if (Objects.nonNull(repository.findBookByName(name)))
			throw new Exception("Book already exists");

		BookEntity savedBookEntity = repository.save(new BookEntity(null, name, pageCount, author));

		return new BookDto(savedBookEntity.getId(), savedBookEntity.getName(), savedBookEntity.getPageCount(),
				savedBookEntity.getAuthor());
	}

	@Override
	public BookDto updateBook(String oldName, String newName, Integer pageCount, String author) throws Exception {

		BookEntity book = repository.findBookByName(oldName);

		if (Objects.isNull(book))
			throw new Exception("Book not found");

		if (author == null && Objects.isNull(pageCount)) {
			book.setName(newName);
		} else if (newName == null && author == null) {
			book.setPageCount(pageCount);
		} else if (newName == null && Objects.isNull(pageCount)) {
			book.setAuthor(author);
		} else {
			book.setName(newName);
			book.setPageCount(pageCount);
			book.setAuthor(author);
		}

		BookEntity updatedBook = repository.save(book);

		return new BookDto(updatedBook.getId(), updatedBook.getName(), updatedBook.getPageCount(),
				updatedBook.getAuthor());
	}

	@Override
	public List<BookDto> listAllBooks(int size, int page) {
		
		List<BookDto> books = new ArrayList<>();
		
		repository.findAll(PageRequest.of(page, size)).forEach((book) -> {
			books.add(new BookDto(book.getId(), book.getName(), book.getPageCount(), book.getAuthor()));
		});
		
		return books;
	}

	@Override
	public BookDto deleteBook(String name) throws Exception {
		
		BookEntity book = repository.findBookByName(name);
		
		if(Objects.isNull(book))
			throw new Exception("Book not found");
		
		repository.delete(book);
		return new BookDto(book.getId(), book.getName(), book.getPageCount(), book.getAuthor());
	}

}