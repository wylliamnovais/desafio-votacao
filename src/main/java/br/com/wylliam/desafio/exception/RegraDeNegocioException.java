package br.com.wylliam.desafio.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegraDeNegocioException extends RuntimeException {

    private static final Logger log = Logger.getLogger(RegraDeNegocioException.class.getName());

    public RegraDeNegocioException(String message) {
        super(message);
        log.log(Level.SEVERE, message);
    }


    public RegraDeNegocioException(String message, Throwable cause) {
        super(message, cause);
        cause.printStackTrace();
        log.log(Level.SEVERE, () -> NestedExceptionUtils.buildMessage(message, cause));
    }
}
