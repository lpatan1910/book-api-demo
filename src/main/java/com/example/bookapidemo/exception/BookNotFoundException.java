package com.example.bookapidemo.exception;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String isbn) {
        super("could not find book with ISBN: '" + isbn + "'");
    }
}
