package com.codegym.books.services;

import com.codegym.books.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void delete(Book book);
}
