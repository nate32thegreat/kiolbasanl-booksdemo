package com.cybr406.books;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "books", types = Author.class)
public interface BookProjection {
  
  String getName();
  
  List<Book> getBooks();
  
}
