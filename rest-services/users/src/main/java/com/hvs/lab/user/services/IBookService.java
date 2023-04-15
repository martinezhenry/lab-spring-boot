package com.hvs.lab.user.services;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.BookDTO;

public interface IBookService {
    // TODO definir contrato
    BookDTO get(long id) throws UserNotFoundException;
    BookDTO create(BookDTO user);
    BookDTO modify(BookDTO user) throws UserNotModifiedException;
    boolean delete(long id) throws UserNotFoundException;
}
