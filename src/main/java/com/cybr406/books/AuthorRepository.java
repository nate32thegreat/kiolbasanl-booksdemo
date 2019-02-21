package com.cybr406.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long> {

//  @Override
//  @PreAuthorize("hasRole('ROLE_ADMIN') or #author.username == authentication.principal.username")
//  <S extends Author> S save(@Param("author") S entity);
  
}
