package com.ism.ismecom.exceptions;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // on appel cette claasse des qu'une exception est soulever
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadGatewayException.class)
    public final ResponseEntity<Object> handlerBadGatewayException(BadGatewayException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handlerBadRequestionException(BadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handlerEntityNotFoundException(EntityNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GatewayTimeoutException.class)
    public final ResponseEntity<Object> handlerGatewayTimeoutException(GatewayTimeoutException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public final ResponseEntity<Object> handlerGatewayTimeoutException(InternalServerErrorException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotImplementedException.class)
    public final ResponseEntity<Object> handlerNotImplementedException(NotImplementedException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(ServiceUnvailableException.class)
    public final ResponseEntity<Object> handlerServiceUnvailableException(ServiceUnvailableException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Object> handlerAuthenticationException(AuthenticationException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    // on pas pas creer cette classe
    //La méthode HTTP utilisée n'est pas autorisée pour cette ressource.
    @ExceptionHandler(MethodNotAllowedException.class)
    public final ResponseEntity<Object> handlerMethodNotAllowedException(MethodNotAllowedException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

}
