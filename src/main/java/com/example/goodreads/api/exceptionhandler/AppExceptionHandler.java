package com.example.goodreads.api.exceptionhandler;

import com.example.goodreads.api.exception.BookNotFoundException;
import com.example.goodreads.api.exception.InvalidRequestException;
import com.example.goodreads.api.exception.UserNameDoesNotExistsException;
import com.example.goodreads.api.exception.UserNameExistsException;
import com.example.goodreads.api.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNameExistsException.class)
    public ResponseEntity<ErrorResponse>
                        userNameExistsExceptionHandler(UserNameExistsException ex, WebRequest request) {
        ErrorResponse response = generateErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(value = UserNameDoesNotExistsException.class)
    public ResponseEntity<ErrorResponse>
                        userNameDoesNotExistsExceptionHandler(UserNameDoesNotExistsException ex, WebRequest request) {
        ErrorResponse response = generateErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ErrorResponse>
                        bookNotFoundExceptionHandler(BookNotFoundException ex, WebRequest webRequest) {
        ErrorResponse response = generateErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<ErrorResponse>
                        invalidRequestExceptionHandler(InvalidRequestException ex, WebRequest request) {
        ErrorResponse response = generateErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse>
                        genericExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponse response = generateErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ErrorResponse generateErrorResponse(Exception ex) {
        ErrorResponse response = new ErrorResponse();
        String errorMessage = ex.getMessage() != null ? ex.getMessage() : ex.getLocalizedMessage();
        response.setErrorMessage(errorMessage);
        response.setTimestamp(LocalDateTime.now(ZoneId.systemDefault()));

        return response;
    }
}
