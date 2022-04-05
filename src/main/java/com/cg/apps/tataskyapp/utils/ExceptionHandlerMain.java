package com.cg.apps.tataskyapp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerMain {

    @ExceptionHandler(value = RechargeNotFoundException.class)
    public ResponseEntity<Object> exception(RechargeNotFoundException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<Object> exception(AccountNotFoundException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AccountAlreadyExistException.class)
    public ResponseEntity<Object> exception(AccountAlreadyExistException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PackNotFoundException.class)
    public ResponseEntity<Object> exception(PackNotFoundException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PackAlreadyExistException.class)
    public ResponseEntity<Object> exception(PackAlreadyExistException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RequestNotFoundException.class)
    public ResponseEntity<Object> exception(RequestNotFoundException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<Object> exception(UserAlreadyExistException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UsernameAlreadyExistException.class)
    public ResponseEntity<Object> exception(UsernameAlreadyExistException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AccountWithUserExistException.class)
    public ResponseEntity<Object> exception(AccountWithUserExistException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoOpenedServiceRequestException.class)
    public ResponseEntity<Object> exception(NoOpenedServiceRequestException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

    }
}