package com.cg.apps.tataskyapp.utils;

public class RechargeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RechargeNotFoundException() {
        super("Recharge does not exist");
    }
}