package com.test.demo.exceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.demo.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(com.test.demo.exceptionHandle.DepartmentNotFound.class)
	public ResponseEntity<ErrorMessage> DepartmentNotFound(DepartmentNotFound exception, WebRequest request)
	
	{
    	ErrorMessage message = new ErrorMessage();
    	message.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	
	}
    @ExceptionHandler(com.test.demo.exceptionHandle.DuplicateEmailAddress.class)
   	public ResponseEntity<ErrorMessage> DuplicateEmailAddress(DuplicateEmailAddress exception, WebRequest request)
   	
   	{
       	ErrorMessage message = new ErrorMessage();
       	message.setMessage(exception.getMessage());
   		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
   	
   	}
}
