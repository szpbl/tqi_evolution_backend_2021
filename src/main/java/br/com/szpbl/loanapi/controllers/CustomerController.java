package br.com.szpbl.loanapi.controllers;

import br.com.szpbl.loanapi.dto.request.CustomerDTO;
import br.com.szpbl.loanapi.dto.response.CustomerResponseDTO;
import br.com.szpbl.loanapi.exceptions.CustomerNotFoundException;
import br.com.szpbl.loanapi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO register(@RequestBody @Valid CustomerDTO customerDTO) {
        return customerService.register(customerDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }

}
