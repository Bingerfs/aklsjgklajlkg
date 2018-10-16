package com.practica2.practica2.repositories;

import com.practica2.practica2.entities.Author;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
