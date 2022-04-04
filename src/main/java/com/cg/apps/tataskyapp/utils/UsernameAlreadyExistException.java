package com.cg.apps.tataskyapp.utils;

public class UsernameAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsernameAlreadyExistException() {
        super("Username already exists...");
    }
}