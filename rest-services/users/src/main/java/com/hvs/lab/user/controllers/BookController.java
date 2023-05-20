package com.hvs.lab.user.controllers;


import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.models.Book;
import com.hvs.lab.user.models.User;
import com.hvs.lab.user.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Book getBook(@PathVariable long id) throws BookNotFoundException {
        return this.bookService.getBook(id);
    }


}
