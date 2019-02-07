package com.cybr406.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  
//  @InitBinder
//  void initBinder(WebDataBinder dataBinder) {
//    dataBinder.addValidators(new AuthorValidator());
//  }
  
  @Autowired
  BookRepository bookRepository;
  
}
