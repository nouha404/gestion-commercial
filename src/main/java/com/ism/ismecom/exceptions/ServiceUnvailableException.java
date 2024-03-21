package com.ism.ismecom.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnvailableException extends RuntimeException {
    private String message;
    //Le serveur est temporairement indisponible en raison d'une surcharge ou de travaux de maintenance. Veuillez réessayer ultérieurement
}
