package br.com.szpbl.loanapi.dto.request;

import br.com.szpbl.loanapi.entities.Address;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String rg;

    @Valid
    @NotEmpty
    private Address address;

    @NotEmpty
    private double income;

    @NotEmpty
    private String password;
}
