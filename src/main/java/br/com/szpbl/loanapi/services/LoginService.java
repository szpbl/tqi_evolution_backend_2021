package br.com.szpbl.loanapi.services;

import br.com.szpbl.loanapi.dto.request.LoginDTO;
import br.com.szpbl.loanapi.dto.response.MessageResponseDTO;
import br.com.szpbl.loanapi.entities.Customer;
import br.com.szpbl.loanapi.exceptions.UnauthorizedException;
import br.com.szpbl.loanapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    public MessageResponseDTO login(LoginDTO loginDTO) throws Exception {
        Customer customer = customerService.findCustomerByEmail(loginDTO.getEmail());

        if (loginDTO.getPassword().equals(customer.getPassword())) {
            customer.setLoggedIn(true);
            customerRepository.save(customer);
        } else {
            throw new UnauthorizedException("Wrong e-mail or password!");
        }

        return generateResponse(String.format("Welcome, %s!", customer.getName()));
    }

    public MessageResponseDTO logoff(Long id) throws Exception {

        Customer customer = customerService.findCustomerById(id);

        if (customer.isLoggedIn()) {
            customer.setLoggedIn(false);
            customerRepository.save(customer);
        }

        return generateResponse(String.format("Goodbye, %s!", customer.getName()));
    }

    private MessageResponseDTO generateResponse(String message) {
        return MessageResponseDTO.builder()
                .message(message)
                .build();
    }
}
