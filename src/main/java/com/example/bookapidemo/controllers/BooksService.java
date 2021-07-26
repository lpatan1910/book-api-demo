package com.example.bookapidemo.controllers;

import com.example.bookapidemo.domains.Book;
import com.example.bookapidemo.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepository repository;

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        repository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public void createBook(Book book) {
        repository.save(book);
    }

    public Optional<Book> getBookById(String isbn) {
        return repository.findById(isbn);
    }
}
