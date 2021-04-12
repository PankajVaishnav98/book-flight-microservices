package com.mindtree.learning.userdetails.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandlers {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ApplicationException exception, WebRequest request, Model model) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
				request.getDescription(false));

		model.addAttribute("error", errorDetails);
		return ResponseEntity.ok().body(errorDetails);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> resourceNotFoundHandling(Exception exception, WebRequest request, Model model) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(),
				request.getDescription(false));
		model.addAttribute("error", errorDetails);
		return ResponseEntity.ok().body(errorDetails);
	}
}
