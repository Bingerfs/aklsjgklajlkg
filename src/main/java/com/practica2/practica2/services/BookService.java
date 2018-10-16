package com.practica2.practica2.services;

import com.practica2.practica2.entities.Book;

public interface BookService {
    Iterable<Book> listAllBooks();
    Book findBook(Integer id);
    void saveBook(Book book);
    void deleteBook(Integer id);
}
