package com.cg.apps.tataskyapp.utils;

public class PackNotMatchedException extends RuntimeException {

    public PackNotMatchedException() {
        super("Pack does not match");
    }

}
