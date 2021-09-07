package br.com.builder.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<MsgError> objecNotFound(ObjectNotFoundException e, HttpServletRequest req, HttpServletResponse res){
		MsgError error = MsgError.builder().status(HttpStatus.NOT_FOUND.value()).msg(e.getMessage()).horario(System.currentTimeMillis()).build();
		return ResponseEntity.status(HttpStatus.OK).body(error);
	}
}
