package com.practica2.practica2.services;

import com.practica2.practica2.entities.Author;
import com.practica2.practica2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;


    @Autowired
    @Qualifier(value = "authorRepository")
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthor(Integer id){
        Optional<Author> opt;
        opt = authorRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveAuthor(Author author) { authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }

}
