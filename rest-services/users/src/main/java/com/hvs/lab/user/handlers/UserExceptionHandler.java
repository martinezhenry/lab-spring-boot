package com.hvs.lab.user.handlers;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class, UserNotModifiedException.class })
        public ResponseEntity<ErrorMessage> userNotFoundException(Exception exception) {
        log.error("Exception: ", exception);
        int status;
        if (exception instanceof UserNotFoundException) {
            status = HttpStatus.NOT_FOUND.value();
        } else {
            status = HttpStatus.BAD_REQUEST.value();
        }
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(status);
        errorMessage.setMessage(exception.getMessage());

        return ResponseEntity.status(status).body(errorMessage);
    }


    //@ExceptionHandler({ UserNotModifiedException.class })
    public ResponseEntity<ErrorMessage> userNotModifiedException(UserNotModifiedException exception) {
        log.error("Exception: ", exception);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(errorMessage);
    }

}
