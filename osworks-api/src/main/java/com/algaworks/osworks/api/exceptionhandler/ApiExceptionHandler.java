package com.algaworks.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.osworks.api.exceptionhandler.ExceptionObject.Campo;
import com.algaworks.osworks.domain.exception.NegocioException;

/**
 * Componente do Spring. 
 * Exceções serão trazidas para esta classe, onde serão tratadas e as respostas ao cliente serão de forma mais adequada.
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Trata as exceções de MethodArgumentNotValidException, 
	 * que são para erro de validação.
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Campo> campos = new ArrayList<ExceptionObject.Campo>();
 
		ex.getBindingResult().getAllErrors().forEach(error -> {  
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new Campo(nome, mensagem));
		});

		ExceptionObject erro = new ExceptionObject(status.value(), OffsetDateTime.now(), "Erro de validação", campos);

		return super.handleExceptionInternal(ex, erro, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleDomainExpection(NegocioException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ExceptionObject erro = new ExceptionObject(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
		return super.handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}

}
