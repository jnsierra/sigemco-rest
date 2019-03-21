package co.com.codesoftware.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.codesoftware.dto.error.ResponseRestService;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseRestService> handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println(
				"**************************Mensaje Controlado por aspecto (ExceptionHandler)*******************************************");
		ex.printStackTrace();
		System.out.println("*********************************************************************");
		ResponseRestService errorDetails = new ResponseRestService<>(
				((ServletWebRequest) request).getRequest().getMethod(),
				((ServletWebRequest) request).getRequest().getRequestURL().toString(),
				SecurityContextHolder.getContext().getAuthentication().getName(), ex.getMessage());
		if (ex instanceof JpaSystemException) {			
			errorDetails.setDeveloperMessage("Error jpa");
		} else if (ex instanceof DataIntegrityViolationException) {
			errorDetails.setDeveloperMessage("Error violacion de llave");
		} else if (ex instanceof TransactionSystemException) {
			TransactionSystemException excepcionCast = (TransactionSystemException) ex;
			errorDetails.setDeveloperMessage(errorDetails.getMessage() + " " + ex.getCause());
		} else if(ex instanceof AccessDeniedException ) {
			errorDetails.setDeveloperMessage(".::No tiene acceso a este recurso, consulte los roles rest del usuario autenticado::.");
			return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
		} else {
			errorDetails.setDeveloperMessage("Error no controlado por favor informar al administrador");
		}
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
