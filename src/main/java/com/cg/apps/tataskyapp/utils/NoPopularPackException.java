package com.cg.apps.tataskyapp.utils;

public class NoPopularPackException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoPopularPackException() {
        super("No popular packs found");
    }

}