package com.cg.apps.tataskyapp.utils;

public class AccountWithUserExistException extends  RuntimeException{

    public AccountWithUserExistException() {
        super("Account with User already exist");
    }

}
