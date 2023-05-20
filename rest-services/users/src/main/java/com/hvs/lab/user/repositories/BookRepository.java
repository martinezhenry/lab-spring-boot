package com.hvs.lab.user.repositories;

import com.hvs.lab.user.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}