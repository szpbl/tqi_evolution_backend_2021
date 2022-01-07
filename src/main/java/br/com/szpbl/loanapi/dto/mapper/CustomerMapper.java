package br.com.szpbl.loanapi.dto.mapper;

import br.com.szpbl.loanapi.dto.request.CustomerDTO;
import br.com.szpbl.loanapi.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toModel(CustomerDTO customerDTO);

    CustomerDTO toDTO(Customer customer);
}
