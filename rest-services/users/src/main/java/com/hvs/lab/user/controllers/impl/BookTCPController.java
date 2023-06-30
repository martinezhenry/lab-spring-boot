package com.hvs.lab.user.controllers.impl;

import com.hvs.lab.user.controllers.IBookController;
import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.exceptions.BookNotModifiedException;
import com.hvs.lab.user.exceptions.GeneralException;
import com.hvs.lab.user.models.BookDTO;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.Socket;

public class BookTCPController implements IBookController {


    public boolean connection() throws IOException {
        Socket socket = new Socket("", 1000);
        return true;
    }

    @Override
    public BookDTO get(long id) throws BookNotFoundException {
        return null;
    }

    @Override
    public BookDTO create(BookDTO bookDTO) throws GeneralException {
        return null;
    }

    @Override
    public BookDTO modify(BookDTO bookDTO) throws BookNotModifiedException, GeneralException {
        return null;
    }

    @Override
    public void delete(long id) throws BookNotFoundException {

    }
}
