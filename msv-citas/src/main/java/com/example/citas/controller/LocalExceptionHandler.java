package com.example.citas.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.commons.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class LocalExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e){
		log.error("error en la integridad de los datos: {}", e);
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"error en la integridad de los datos: "+ e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}
}
