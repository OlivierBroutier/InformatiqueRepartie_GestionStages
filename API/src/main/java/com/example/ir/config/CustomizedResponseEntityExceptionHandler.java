package com.example.ir.config;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Logger slf4j plutôt que de logger d'appache déclaré dans
    // ResponseEntityExceptionHandler
    private static final Logger customLogger =
            LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);

    @ExceptionHandler(FonctionnelException.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(FonctionnelException ex, WebRequest request) {
        HttpStatus httpStatus = null;
        ErrorDetails errorDetails = null;
        if (ex instanceof FonctionnelException) {
            customLogger.error("Fonctionnel Exception", ex);
            errorDetails =
                    new ErrorDetails(
                            new Date(),
                            ex.getMessage(),
                            request.getDescription(false),
                            ((FonctionnelException) ex).getCode());
            httpStatus = ((FonctionnelException) ex).getHttpStatus();
        } else {
            customLogger.error("Default Exception Handler", ex);
            errorDetails =
                    new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false), "");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(errorDetails, httpStatus);
    }
}
