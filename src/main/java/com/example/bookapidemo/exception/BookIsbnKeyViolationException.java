package com.example.bookapidemo.exception;

public class BookIsbnKeyViolationException extends Throwable {
    public BookIsbnKeyViolationException(String isbn) {
        super("book already exists for ISBN: '" + isbn + "'");
    }
}
