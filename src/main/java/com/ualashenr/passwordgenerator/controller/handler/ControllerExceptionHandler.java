package com.ualashenr.passwordgenerator.controller.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ualashenr.passwordgenerator.exceptions.CustomError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomError> IllegalArgument(IllegalArgumentException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(), "Por favor insira dados válidos.", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
