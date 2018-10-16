package com.practica2.practica2.repositories;

import com.practica2.practica2.entities.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends CrudRepository<Book, Integer> {

}
