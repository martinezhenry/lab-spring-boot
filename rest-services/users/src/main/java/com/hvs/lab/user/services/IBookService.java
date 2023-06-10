package com.hvs.lab.user.services;

import com.hvs.lab.user.exceptions.*;
import com.hvs.lab.user.models.BookDTO;

public interface IBookService {
    // TODO definir contrato
    BookDTO get(long id) throws BookNotFoundException;
    BookDTO create(BookDTO user) throws GeneralException;
    BookDTO modify(BookDTO user) throws BookNotModifiedException, GeneralException;
    boolean delete(long id) throws BookNotFoundException;
}
