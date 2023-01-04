package com.treina.treina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//Classe de filtro das exception
@RestControllerAdvice
public class RestExceptionHandler {

    //metodo da BadRequestException(exception customizada)
    @ExceptionHandler(BadRequestException.class)//quando acontecer essa exception
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

    //Metodo da validação
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(objectError -> {
            String fildName = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(fildName, errorMessage);
        });
        return errors;
    }


}
