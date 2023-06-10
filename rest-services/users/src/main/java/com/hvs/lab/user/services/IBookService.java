package com.hvs.lab.user.services;

import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.exceptions.BookNotModifiedException;
import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.BookDTO;

public interface IBookService {
    // TODO definir contrato
    BookDTO get(long id) throws BookNotFoundException;
    BookDTO create(BookDTO user);
    BookDTO modify(BookDTO user) throws BookNotModifiedException;
    boolean delete(long id) throws BookNotFoundException;
}
