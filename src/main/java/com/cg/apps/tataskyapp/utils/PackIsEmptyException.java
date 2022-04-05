package com.cg.apps.tataskyapp.utils;

public class PackIsEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PackIsEmptyException() {
        super("Pack is empty");
    }

}
