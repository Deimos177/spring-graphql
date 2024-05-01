package br.com.deimos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "book")
public class BookEntity {
	
	@Id
	private String id;
	private String name;
	private Integer pageCount;
	private String author;
}