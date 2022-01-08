package br.com.szpbl.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class FailedLoginException extends Exception{

    public FailedLoginException(){
        super("Wrong e-mail or password!");
    }
}
