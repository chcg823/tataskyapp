package com.cg.apps.tataskyapp.utils;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException extends RuntimeException{

    private final String messsage;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public ApiException(String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.messsage = messsage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public ApiException(String message, String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        super(message);
        this.messsage = messsage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public ApiException(String message, Throwable cause, String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        super(message, cause);
        this.messsage = messsage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public ApiException(Throwable cause, String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        super(cause);
        this.messsage = messsage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.messsage = messsage;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMesssage() {
        return messsage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    /*
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> exception(ItemNotFoundException ex){
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	*/



}
