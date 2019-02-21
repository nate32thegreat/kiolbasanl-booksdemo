package com.cybr406.books;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {
  
  @GetMapping("/rest-demo")
  public String restDemo() {
    return "This is a rest demo.";
  }
  
}
