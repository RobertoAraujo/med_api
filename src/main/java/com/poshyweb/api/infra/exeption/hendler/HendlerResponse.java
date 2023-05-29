package com.poshyweb.api.infra.exeption.hendler;

import com.poshyweb.api.infra.exeption.response.errocliente.*;
import com.poshyweb.api.infra.exeption.response.errorserver.Error500;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class HendlerResponse extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Error400.class)
    public final ResponseEntity<Error400> handlerAllBadResquestException(Exception ex, WebRequest request) {
        Error400 error400 = new Error400(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error400, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Error401.class)
    public final ResponseEntity<Error401> handlerAllUnauthorizedException(Exception ex, WebRequest request) {
        Error401 error401 = new Error401(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error401, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(Error402.class)
    public final ResponseEntity<Error402> handlerAllPaymentRequiredException(Exception ex, WebRequest request) {
        Error402 error402 = new Error402(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error402, HttpStatus.PAYMENT_REQUIRED);
    }
    @ExceptionHandler(Error403.class)
    public final ResponseEntity<Error403> handlerAllForBiddenException(Exception ex, WebRequest request) {
        Error403 error403 = new Error403(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error403, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(Error404.class)
    public final ResponseEntity<Error404> handlerAllNotFoundException(Exception ex) {
        Error404 error404 = new Error404(new Date(), ex.getMessage());
        return new ResponseEntity<>(error404, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error500> handlerAllException(Exception ex, WebRequest request){
        Error500 error500 = new Error500(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error500, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
