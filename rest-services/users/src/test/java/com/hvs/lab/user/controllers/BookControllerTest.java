package com.hvs.lab.user.controllers;

import com.hvs.lab.user.controllers.impl.BookController;
import com.hvs.lab.user.exceptions.BookNotFoundException;
import com.hvs.lab.user.models.BookDTO;
import com.hvs.lab.user.services.impl.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BookControllerTest {


    @MockBean
    private BookService bookService;
    @Autowired
    private BookController bookController;


    @Test
    @Timeout(1)
    void get2SuccessfulTest() throws InterruptedException {
        // Given
        var bookController = new BookController(null);

        // When
        var result = bookController.get2();

        // Then
        var expectedResult = "Hello World!!!";
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);
        Assertions.assertFalse((result.length() > 20));

    }

    @Test
    void getSuccessfulTest() throws BookNotFoundException {
        // Given
        var bookId = 1000;

        var bookResult = new BookDTO();
        bookResult.setId(1000);

        Mockito.when(bookService.get(bookId)).thenReturn(bookResult);


        // When
        var book = bookController.get(bookId);

        // Then
        Assertions.assertNotNull(book);
        Assertions.assertEquals(bookId, book.getId());
    }

    @Test
    void getFailsWithBookNotFoundTest() throws BookNotFoundException {
        // Given
        var bookId = 1000;

        Mockito.when(bookService.get(bookId)).thenThrow(new BookNotFoundException());


        // When
        Assertions.assertThrows(BookNotFoundException.class,
                () -> {
                    var book = bookController.get(bookId);

                    // Then
                    Assertions.assertNull(book);
                }
        );

    }


}
