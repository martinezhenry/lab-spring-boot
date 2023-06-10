package com.hvs.lab.user.controllers;

import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.exceptions.BookNotModifiedException;
import com.hvs.lab.user.exceptions.GeneralException;
import com.hvs.lab.user.models.BookDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBookController {
    BookDTO get(@PathVariable long id) throws BookNotFoundException;
    BookDTO create(@RequestBody BookDTO bookDTO) throws GeneralException;
    BookDTO modify(@RequestBody BookDTO bookDTO) throws BookNotModifiedException, GeneralException;
    void delete(@PathVariable long id) throws BookNotFoundException;
}
