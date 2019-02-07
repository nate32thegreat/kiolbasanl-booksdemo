package com.cybr406.books;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AuthorValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.equals(Author.class);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(
        errors,
        "name",
        "field.required",
        "Name is a required field.");
  }
  
}
