package com.example.bookapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BooksControllerAdvice {
    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    BookError bookNotFoundExceptionHandler(BookNotFoundException ex) {
        return new BookError("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BookIsbnAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    BookError bookIsbnAlreadyExistsExceptionHandler(BookIsbnAlreadyExistsException ex) {
        return new BookError("error", ex.getMessage());
    }
}
