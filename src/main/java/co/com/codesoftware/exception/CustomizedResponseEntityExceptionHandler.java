package co.com.codesoftware.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.codesoftware.dto.error.ErrorDetails;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setUri(((ServletWebRequest)request).getRequest().getRequestURL().toString());
		errorDetails.setMethod(((ServletWebRequest)request).getRequest().getMethod());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
		if(ex instanceof JpaSystemException ) {
			errorDetails.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			errorDetails.setCode(001);
			errorDetails.setDeveloperMessage("Error jpa");
		}else if(ex instanceof DataIntegrityViolationException) {
			errorDetails.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			errorDetails.setCode(002);
			errorDetails.setDeveloperMessage("Error violacion de llave");
		}
		
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
