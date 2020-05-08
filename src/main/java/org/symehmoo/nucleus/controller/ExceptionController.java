package org.symehmoo.nucleus.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.symehmoo.nucleus.model.ErrorRto;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class ExceptionController {

	private static final Logger logger = LogManager.getLogger(ExceptionController.class);

	@Autowired
	ObjectMapper mapper;

	/**
	 * Exception handler added to handle all exceptions.
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorRto> exceptionHandler(Exception exception) {
		ErrorRto error = new ErrorRto();
		error.setError(exception.getMessage());
		logger.debug("Exception during calling api:{}", error);
		return ResponseEntity.badRequest().body(error);
	}
}