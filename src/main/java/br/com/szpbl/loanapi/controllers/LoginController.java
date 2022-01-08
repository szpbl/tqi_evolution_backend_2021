package br.com.szpbl.loanapi.controllers;

import br.com.szpbl.loanapi.dto.request.LoginDTO;
import br.com.szpbl.loanapi.dto.response.MessageResponseDTO;
import br.com.szpbl.loanapi.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final LoginService loginService;

    @PutMapping
    public MessageResponseDTO login(@RequestBody LoginDTO loginDTO) throws Exception {
        return loginService.login(loginDTO);
    }

    @PutMapping("out/{id}")
    public MessageResponseDTO logoff(@PathVariable Long id) throws Exception {
        return loginService.logoff(id);
    }
}
