package com.cg.apps.tataskyapp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandler {
	@ExceptionHandler(value = RechargeNotFoundException.class)
	public ResponseEntity<Object> exception(RechargeNotFoundException e){
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	/*
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> exception(ItemNotFoundException ex){
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	*/
	

}
