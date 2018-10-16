package com.practica2.practica2.services;

import com.practica2.practica2.entities.Author;

public interface AuthorService {
    Iterable<Author> listAllAuthors();
    Author findAuthor(Integer id);
    void saveAuthor(Author author);
    void deleteAuthor(Integer id);
}
