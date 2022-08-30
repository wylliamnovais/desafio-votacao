package br.com.wylliam.desafio.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ResponseError responseDefault = ResponseDefaultBuilder.builder().badRequest().mensagemRetornoServico(errors.toString()).build();
        return new ResponseEntity<>(responseDefault, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RegraDeNegocioException.class})
    public ResponseEntity<ResponseError> regraDeNegocioException(RegraDeNegocioException exception) {
        ResponseError responseDefault = ResponseDefaultBuilder.builder().badRequest().mensagemRetornoServico(exception.getMessage()).build();
        return new ResponseEntity<ResponseError>(responseDefault, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ExceptionDefault.class})
    public ResponseEntity<ResponseError> exceptionDefault(ExceptionDefault exception) {
        ResponseError responseDefault = ResponseDefaultBuilder.builder().internalServerError().mensagemRetornoServico(exception.getMessage()).build();
        return new ResponseEntity<ResponseError>(responseDefault, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}