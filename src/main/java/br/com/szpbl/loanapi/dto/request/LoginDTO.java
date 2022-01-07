package br.com.szpbl.loanapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
