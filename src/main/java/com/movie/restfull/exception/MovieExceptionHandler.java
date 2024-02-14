package com.movie.restfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<MovieErrorRespon> handleExceptionNotFound (MovieNotFoundException exc){
        MovieErrorRespon error = new MovieErrorRespon();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


}
