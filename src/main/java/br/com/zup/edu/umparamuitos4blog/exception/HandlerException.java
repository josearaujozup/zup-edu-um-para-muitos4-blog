package br.com.zup.edu.umparamuitos4blog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        MensagemDeErro messages = new MensagemDeErro();
        e.getBindingResult().getFieldErrors().forEach(messages::adicionarErrorPeloFieldError);
        return ResponseEntity.badRequest().body(messages);
    }
	
}
