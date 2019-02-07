package com.cybr406.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class AuthorEventHandler {
  
  Logger logger = LoggerFactory.getLogger(AuthorEventHandler.class);
  
  @HandleAfterCreate
  public void handleAuthorCreated(Author author) {
    logger.info("Author {} created.", author.getName());
  }
  
}
