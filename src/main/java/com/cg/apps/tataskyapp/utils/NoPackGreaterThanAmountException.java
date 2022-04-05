package com.cg.apps.tataskyapp.utils;

public class NoPackGreaterThanAmountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoPackGreaterThanAmountException() {
        super("No Packs found greater than the given amount");
    }

}