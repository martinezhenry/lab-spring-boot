package com.hvs.lab.user.services;


import com.hvs.lab.user.entities.BookEntity;
import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.models.Book;
import com.hvs.lab.user.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(long id) throws BookNotFoundException {

        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        // Con el uso de la clase Optional validamos si existe el usuario consultado con el id
        // sino disparamos una exepcion
        bookEntity.orElseThrow(
                () -> new BookNotFoundException(String.format("El libro con el id %s no existe", id))
        );

        Book book = new Book();
        book.setISNB(bookEntity.get().getISNB());
        book.setDescripcion(bookEntity.get().getDescripcion());
        book.setTitulo(bookEntity.get().getTitulo());

        return book;

    }


}
