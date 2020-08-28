package com.wwwgomes.customermanager.domain.exception.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wwwgomes.customermanager.domain.exception.EntityInUseException;
import com.wwwgomes.customermanager.domain.exception.EntityNotFoundException;
import com.wwwgomes.customermanager.domain.exception.InvalidOperationException;
import com.wwwgomes.customermanager.domain.exception.model.ErrorItem;
import com.wwwgomes.customermanager.domain.exception.model.StandardError;

@ControllerAdvice
public class HandlerExceptions {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<StandardError> objectNotFound(Throwable e, HttpServletRequest req) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal failure", Arrays.asList(), e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> objectNotFound(HttpMessageNotReadableException e, HttpServletRequest req) {

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Unrecognized property", Arrays.asList(), getPropertyMessageError(e), req.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest req) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Entity Not Found", Arrays.asList(), e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(InvalidOperationException.class)
	public ResponseEntity<StandardError> invalidOperation(InvalidOperationException e, HttpServletRequest req) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Invalid Operation", Arrays.asList(), e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(err);
	}

	@ExceptionHandler(EntityInUseException.class)
	public ResponseEntity<StandardError> entityInUse(EntityInUseException e, HttpServletRequest req) {

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Cannot be removed", Arrays.asList(), "Entity with the given id cannot be removed as it is being used.",
				req.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest req) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Malformed request", getValidations(e), "Validation error", req.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	private List<ErrorItem> getValidations(MethodArgumentNotValidException e) {
		List<ErrorItem> errors = new ArrayList<>();
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			errors.add(new ErrorItem(error.getField(), error.getDefaultMessage()));
		}
		return errors;
	}

	private String getPropertyMessageError(HttpMessageNotReadableException e) {
		String message = e.getMostSpecificCause().getMessage();
		message = message.substring(message.indexOf(" \"") + 2);
		message = message.substring(0, message.indexOf("\" "));
		return String.format("The property [%s] is not known.", message);
	}

}
