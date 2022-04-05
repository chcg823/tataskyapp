package com.cg.apps.tataskyapp.utils;

public class PackNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PackNotFoundException() {
        super("Pack does not exist");
    }
}