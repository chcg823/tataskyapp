package com.cg.apps.tataskyapp.utils;

public class RequestNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RequestNotFoundException() {
        super("Service request does not exist");
    }
}