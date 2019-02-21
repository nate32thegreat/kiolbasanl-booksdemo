package com.cybr406.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class AuthorEventHandler {
  
  Logger logger = LoggerFactory.getLogger(AuthorEventHandler.class);
  
  @HandleBeforeSave
  @PreAuthorize("hasRole('ROLE_ADMIN') or #author.username == authentication.principal.username")
  public void handleBeforeSave(Author author) {
    System.out.println("Save an author");
  }
  
  @HandleAfterCreate
  public void handleAuthorCreated(Author author) {
    logger.info("Author {} created.", author.getName());
  }
  
}
