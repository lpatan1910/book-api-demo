package com.example.bookapidemo.repositories;

import com.example.bookapidemo.domains.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, String>{
}
