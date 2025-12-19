package com.bluemoon.bluemoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(404, ex.getMessage()));
	}
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400, ex.getMessage()));
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ApiError> handleConflictException(ConflictException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(409, ex.getMessage()));
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGenericException(Exception ex){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(500, "An unexpected error occurred."));
	}
	
	
}
