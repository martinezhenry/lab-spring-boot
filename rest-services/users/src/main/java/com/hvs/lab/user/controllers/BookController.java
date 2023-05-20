package com.hvs.lab.user.controllers;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.BookDTO;
import com.hvs.lab.user.services.IBookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController implements IBookController {

    private final IBookService bookService;

    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public BookDTO get(@PathVariable long id) throws UserNotFoundException {
        return this.bookService.get(id);
    }

    @PostMapping
    public BookDTO createUser(@RequestBody BookDTO bookDTO){
        return this.bookService.create(bookDTO);
    }

    @PutMapping
    public BookDTO modifyUser(@RequestBody BookDTO bookDTO) throws UserNotModifiedException {
        return this.bookService.modify(bookDTO);
    }


    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) throws UserNotFoundException {
        if (!this.bookService.delete(id)){
            throw new RuntimeException("User Not Deleted");
        }
    }

}
