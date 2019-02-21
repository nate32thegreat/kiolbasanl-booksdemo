package com.cybr406.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
  
  @Autowired
  JdbcUserDetailsManager userDetailsManager;
  
  @Autowired
  AuthorRepository authorRepository;
  
  @Autowired
  User.UserBuilder userBuilder;
  
  @PostMapping("/register")
  public ResponseEntity<Author> register(@RequestBody Registration registration) {
    userDetailsManager.createUser(userBuilder
        .username(registration.getUsername())
        .password(registration.getPassword())
        .roles("AUTHOR")
        .build());
    
    Author author = new Author();
    author.setUsername(registration.getUsername());
    author.setName(registration.getName());
    author.setBio(registration.getBio());
    
    return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
  }
  
  
}
