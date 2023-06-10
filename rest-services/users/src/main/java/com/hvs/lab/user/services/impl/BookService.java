package com.hvs.lab.user.services.impl;


import com.hvs.lab.user.entities.BookEntity;
import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.exceptions.BookNotModifiedException;
import com.hvs.lab.user.exceptions.GeneralException;
import com.hvs.lab.user.models.BookDTO;
import com.hvs.lab.user.models.UserDTO;
import com.hvs.lab.user.repositories.BookRepository;
import com.hvs.lab.user.services.IBookService;
import com.hvs.lab.user.services.ICreate;
import com.hvs.lab.user.services.ICrud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService, ICreate {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDTO get(long id) throws BookNotFoundException {

        BookRepository bookRepository = new BookRepository() {
            @Override
            public <S extends BookEntity> S save(S entity) {
                return null;
            }

            @Override
            public <S extends BookEntity> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<BookEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<BookEntity> findAll() {
                return null;
            }

            @Override
            public Iterable<BookEntity> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(BookEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends BookEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };

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
        bookDTO.setId(bookEntity.get().getId());

        return bookDTO;

    }

    @Override
    public BookDTO create(BookDTO bookDTO) throws GeneralException {
        if (bookDTO.getId() > 0) {
            throw new GeneralException("book id must be zero or not present in the body request");
        }

        BookEntity bookEntity = new BookEntity();
        bookEntity.setISNB(bookDTO.getISNB());
        bookEntity.setTitulo(bookDTO.getTitulo());
        bookEntity.setDescripcion(bookDTO.getDescripcion());
        bookEntity.setId(bookDTO.getId());

        bookEntity = bookRepository.save(bookEntity);

        bookDTO.setId(bookEntity.getId());

        return bookDTO;
    }

    @Override
    public BookDTO modify(BookDTO bookDTO) throws BookNotModifiedException, GeneralException {
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

    @Override
    public void createAll() {

    }
}
