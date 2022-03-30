package com.cg.apps.tataskyapp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
	/*
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> exception(ItemNotFoundException ex){
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	*/
	

}
