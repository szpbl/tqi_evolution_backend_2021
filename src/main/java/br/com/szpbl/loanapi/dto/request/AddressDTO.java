package br.com.szpbl.loanapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @NotEmpty
    private String streetAddress;

    @NotEmpty
    private int number;

    private String secondaryAddress;

    @NotEmpty
    private String cep;
}
