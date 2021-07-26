package com.example.bookapidemo.exception;

public class BookIsbnAlreadyExistsException extends Throwable {
    public BookIsbnAlreadyExistsException(String isbn) {
        super("book already exists for ISBN: '" + isbn + "'");
    }
}
