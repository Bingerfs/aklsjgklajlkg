package com.practica2.practica2.services;

import com.practica2.practica2.entities.Book;
import com.practica2.practica2.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;


    @Autowired
    @Qualifier(value = "bookRepository")
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBook(Integer id){
        Optional<Book> opt;
        opt = bookRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveBook(Book book) { bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

}
