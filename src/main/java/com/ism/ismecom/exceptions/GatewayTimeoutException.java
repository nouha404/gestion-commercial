package com.ism.ismecom.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
public class GatewayTimeoutException extends RuntimeException {
    private String message;
    //La passerelle ou le proxy n'a pas reçu de réponse en temps opportun du serveur en aval. Veuillez réessayer ultérieurement
}
