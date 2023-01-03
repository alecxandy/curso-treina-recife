package com.treina.treina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//Classe de filtro das exception
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetalis>
    handleBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
                BadRequestExceptionDetalis.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Document")
                        .details(badRequestException.getMessage())
                        .message(badRequestException.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

}
