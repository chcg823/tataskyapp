package com.cg.apps.tataskyapp.utils;

public class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistException() {
        super("User already exist");
    }
}