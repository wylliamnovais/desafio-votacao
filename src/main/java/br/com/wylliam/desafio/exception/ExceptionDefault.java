package br.com.wylliam.desafio.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExceptionDefault extends RuntimeException {

    private static final Logger log = Logger.getLogger(ExceptionDefault.class.getName());

    public ExceptionDefault(String message) {
        super(message);
        log.log(Level.SEVERE, message);
    }


    public ExceptionDefault(String message, Throwable cause) {
        super(message, cause);
        cause.printStackTrace();
        log.log(Level.SEVERE, () -> NestedExceptionUtils.buildMessage(message, cause));
    }
}
