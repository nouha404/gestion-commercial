package com.ism.ismecom.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizeException extends RuntimeException {
    private String message;
    //Vous n'êtes pas autorisé à accéder à cette ressource.
}
