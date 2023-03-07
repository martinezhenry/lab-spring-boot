package com.hvs.lab.user.handlers;

import com.hvs.lab.user.exceptions.GeneralException;
import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.models.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(999)
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler({ GeneralException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage generalException(GeneralException exception) {
        log.error("Exception: ", exception);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorMessage.setMessage(exception.getMessage());
        // Solo setear en ambientes de  Desarrollo, para evitar entregar informacion sensible al usuario final
        // config scope (entorno) dev, si no no setear
        errorMessage.setStackTrace(exception.getStackTrace());

        return errorMessage;
    }


}
