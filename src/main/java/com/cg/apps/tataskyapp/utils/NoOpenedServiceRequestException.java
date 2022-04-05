package com.cg.apps.tataskyapp.utils;

public class NoOpenedServiceRequestException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NoOpenedServiceRequestException() {
        super("There are no opened service requests for this account");
    }
}
