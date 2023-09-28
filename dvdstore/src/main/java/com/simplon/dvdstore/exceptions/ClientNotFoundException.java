package com.simplon.dvdstore.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
public class ClientNotFoundException extends ResponseStatusException {

    public ClientNotFoundException(HttpStatusCode status) {
        super(status);
    }

    public ClientNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
