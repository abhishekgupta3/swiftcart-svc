package com.swiftcart.cartservice.errorHandler;

import com.swiftcart.cartservice.errorHandler.entites.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductException.class)
    public ErrorResponse handleException(ProductException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        System.out.println(errorResponse);

//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
//        ResponseEntity responseEntity = new ResponseEntity<>();
//        responseEntity.s
        return errorResponse;
    }
}
