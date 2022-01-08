package br.com.szpbl.loanapi.controllers;

import br.com.szpbl.loanapi.dto.request.LoanDTO;
import br.com.szpbl.loanapi.dto.response.ListLoanResponseDTO;
import br.com.szpbl.loanapi.dto.response.LoanDetailResponseDTO;
import br.com.szpbl.loanapi.dto.response.LoanResponseDTO;
import br.com.szpbl.loanapi.services.LoanService;
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
@RequestMapping("api/v1/loans")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoanController {

    private LoanService loanService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponseDTO generateLoan(@RequestBody @Valid LoanDTO loanDTO, @PathVariable Long id) throws Exception {
        return loanService.generateLoan(loanDTO, id);
    }

    @GetMapping("client/{id}")
    public ListLoanResponseDTO getLoans(@PathVariable Long id) throws Exception {
        return loanService.listLoans(id);
    }

    @GetMapping("detail/{id}")
    public LoanDetailResponseDTO getLoanDetail(@PathVariable Long id) throws Exception {
        return loanService.getLoanDetail(id);
    }
}
