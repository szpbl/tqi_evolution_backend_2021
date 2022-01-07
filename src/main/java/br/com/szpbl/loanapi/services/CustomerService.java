package br.com.szpbl.loanapi.services;

import br.com.szpbl.loanapi.dto.mapper.CustomerMapper;
import br.com.szpbl.loanapi.dto.request.CustomerDTO;
import br.com.szpbl.loanapi.dto.response.MessageResponseDTO;
import br.com.szpbl.loanapi.entities.Customer;
import br.com.szpbl.loanapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public MessageResponseDTO register(CustomerDTO customerDTO){
        Customer customer = customerMapper.toModel(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);

        return MessageResponseDTO.builder()
                .message(savedCustomer.getName()
                + " registered successfully with id "
                + savedCustomer.getId())
                .build();
    }

}
