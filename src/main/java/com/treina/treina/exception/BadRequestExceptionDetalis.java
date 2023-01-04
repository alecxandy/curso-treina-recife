package com.treina.treina.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//Modelo da Handler
@Data
@Builder//classe statica
public class BadRequestExceptionDetalis {

    private String title;
    private int status;
    private String details;
    private String message;
    private LocalDateTime timeStamp;

}
