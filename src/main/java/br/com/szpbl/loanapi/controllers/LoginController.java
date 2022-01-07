package br.com.szpbl.loanapi.controllers;

import br.com.szpbl.loanapi.dto.request.LoginDTO;
import br.com.szpbl.loanapi.dto.response.MessageResponseDTO;
import br.com.szpbl.loanapi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final CustomerService customerService;

    @PutMapping
    public MessageResponseDTO login(@RequestBody LoginDTO loginDTO) throws Exception {
        return customerService.login(loginDTO);
    }
}
