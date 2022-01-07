package br.com.szpbl.loanapi.dto.request;

import br.com.szpbl.loanapi.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull
    private Address address;

    @NotNull
    private double income;

    @NotEmpty
    private String password;

    private boolean loggedIn;
}
