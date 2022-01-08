package br.com.szpbl.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidLoanException  extends Exception {

    public InvalidLoanException(String message){
        super("Invalid loan informed!" + message);
    }
}
