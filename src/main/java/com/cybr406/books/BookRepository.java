package com.cybr406.books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

  Page<Book> findAllByAuthor(@Param("author") String author, Pageable pageable);

  Page<Book> findAllByAuthorNameLike(@Param("author") String author, Pageable pageable);
  
}
