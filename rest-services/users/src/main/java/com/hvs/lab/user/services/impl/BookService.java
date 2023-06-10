package com.hvs.lab.user.services.impl;


import com.hvs.lab.user.entities.BookEntity;
import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.exceptions.BookNotModifiedException;
import com.hvs.lab.user.models.BookDTO;
import com.hvs.lab.user.repositories.BookRepository;
import com.hvs.lab.user.services.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO get(long id) throws BookNotFoundException {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        // Con el uso de la clase Optional validamos si existe el usuario consultado con el id
        // sino disparamos una exepcion
        bookEntity.orElseThrow(
                () -> new BookNotFoundException(String.format("El libro con el id %s no existe", id))
        );

        BookDTO bookDTO = new BookDTO();
        bookDTO.setISNB(bookEntity.get().getISNB());
        bookDTO.setDescripcion(bookEntity.get().getDescripcion());
        bookDTO.setTitulo(bookEntity.get().getTitulo());

        return bookDTO;

    }

    @Override
    public BookDTO create(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setISNB(bookDTO.getISNB());
        bookEntity.setTitulo(bookDTO.getTitulo());
        bookEntity.setDescripcion(bookDTO.getDescripcion());

        bookEntity = bookRepository.save(bookEntity);

        bookDTO.setId(bookEntity.getId());

        return bookDTO;
    }

    @Override
    public BookDTO modify(BookDTO bookDTO) throws BookNotModifiedException {
        try {
            BookDTO rspBookDTO = this.get(bookDTO.getId());
            if (rspBookDTO != null) {
                rspBookDTO = create(bookDTO);
            } else {

            }
            return rspBookDTO;
        } catch (BookNotFoundException e) {
            log.error(String.format("El book %s no existe, por lo tanto no fue modificado", bookDTO.getId()));
            throw new BookNotModifiedException(String.format("El book %s no existe, por lo tanto no fue modificado", bookDTO.getId()));
        }
    }

    @Override
    public boolean delete(long id) throws BookNotFoundException {
        BookDTO rspBookDTO = this.get(id);
        if (rspBookDTO != null) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
