package com.cybr406.books.configuration;

import com.cybr406.books.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class AppConfiguration implements RepositoryRestConfigurer {

  @Autowired
  AuthorValidator authorValidator;
  
  @Override
  public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
    validatingListener.addValidator("beforeSave", authorValidator);
    validatingListener.addValidator("beforeCreate", authorValidator);
  }
  
}
