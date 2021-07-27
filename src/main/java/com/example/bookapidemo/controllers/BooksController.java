package com.example.bookapidemo.controllers;

import com.example.bookapidemo.domains.Book;
import com.example.bookapidemo.exception.BookIsbnKeyViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1")
@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Book> getBooks() {
        return booksService.getBooks();
    }

    @GetMapping("/books/{isbn}")
    public Book getBooksById(@PathVariable("isbn") String isbn) {
        return booksService.getBookById(isbn).orElse(null);
    }

    @PostMapping("/books")
    public ResponseEntity getBooksById(@RequestBody Book book) throws BookIsbnKeyViolationException {
        if (booksService.getBookById(book.getIsbn()).isPresent()) {
            throw new BookIsbnKeyViolationException(book.getIsbn());
        }
        booksService.createBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
