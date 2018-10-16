package com.practica2.practica2.controllers;

import com.practica2.practica2.entities.Author;
import com.practica2.practica2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorservice) {this.authorService=authorservice;}

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String index( Model model) {
        List<Author> authors  = (List) authorService.listAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("author", author);
        return "showAuthor";
    }
    @RequestMapping(value = "/author/new", method = RequestMethod.GET)
    public String newAuthor( Model model) {
        model.addAttribute("author", new Author());
        return "newAuthor";
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public String create(@ModelAttribute("author") @Valid Author author, Model model) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @RequestMapping(value= "/author/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }


}
