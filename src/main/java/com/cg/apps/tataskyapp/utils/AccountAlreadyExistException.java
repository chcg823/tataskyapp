package com.cg.apps.tataskyapp.utils;

public class AccountAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public AccountAlreadyExistException() {
        super("Account already exist");
    }
}