package br.com.szpbl.loanapi.dto.response;

import br.com.szpbl.loanapi.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String rg;

    private Address address;

    private double income;

}
