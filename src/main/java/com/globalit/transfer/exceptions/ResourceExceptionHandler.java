package com.globalit.transfer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(TransferConflictException.class)
    public ResponseEntity<MessageError> userConflictException(TransferConflictException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(MessageError.builder().message(e.getMessage()).build());

    }
    @ExceptionHandler(TransferNotFoundException.class)
    public ResponseEntity<MessageError> userNotFoundException(TransferNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageError.builder().message(e.getMessage()).build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> handlerValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(MessageError.builder().message("Existem problemas no seu request").erros(errors).build());
    }

}
