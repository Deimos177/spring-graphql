package br.com.deimos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.deimos.entity.BookEntity;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String>{
	public BookEntity findBookByName(String name);
}