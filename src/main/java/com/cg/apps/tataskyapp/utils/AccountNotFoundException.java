package com.cg.apps.tataskyapp.utils;

public class AccountNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public AccountNotFoundException() {
        super("Account does not exist");
    }
}