package com.cg.apps.tataskyapp.utils;

public class PackAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PackAlreadyExistException() {
        super("Pack already exist");
    }
}