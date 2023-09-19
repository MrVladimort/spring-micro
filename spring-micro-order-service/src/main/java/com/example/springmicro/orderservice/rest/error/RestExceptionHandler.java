package com.example.springmicro.orderservice.rest.error;

import com.example.springmicro.orderservice.domain.error.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.example.mrvladimort.springmicro.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

@RestControllerAdvice
@Slf4j
class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorDTO handleResourceNotFound(ResourceNotFoundException ex) {
        log.debug("handling exception::" + ex);

        return ApiErrorDTO.builder()
                .message("Resource not found")
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDTO handleWebExchangeBindException(WebExchangeBindException ex) {
        log.debug("handling exception::" + ex);

        return ApiErrorDTO.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
