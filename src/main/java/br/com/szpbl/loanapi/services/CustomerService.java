package br.com.szpbl.loanapi.services;

import br.com.szpbl.loanapi.dto.mapper.CustomerMapper;
import br.com.szpbl.loanapi.dto.request.CustomerDTO;
import br.com.szpbl.loanapi.dto.response.CustomerResponseDTO;
import br.com.szpbl.loanapi.entities.Customer;
import br.com.szpbl.loanapi.exceptions.CustomerNotFoundException;
import br.com.szpbl.loanapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerResponseDTO register(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toModel(customerDTO);
        customer.setLoggedIn(false);
        Customer savedCustomer = customerRepository.save(customer);

        return new CustomerResponseDTO(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail(), savedCustomer.getCpf(), savedCustomer.getRg(), savedCustomer.getAddress(), savedCustomer.getIncome());
    }

    public CustomerDTO getCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));

        return customerMapper.toDTO(customer);
    }

    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }

    public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }
}
