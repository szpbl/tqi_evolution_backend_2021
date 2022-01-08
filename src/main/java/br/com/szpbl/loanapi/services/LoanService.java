package br.com.szpbl.loanapi.services;

import br.com.szpbl.loanapi.dto.mapper.LoanMapper;
import br.com.szpbl.loanapi.dto.request.LoanDTO;
import br.com.szpbl.loanapi.dto.response.MessageResponseDTO;
import br.com.szpbl.loanapi.entities.Customer;
import br.com.szpbl.loanapi.entities.Loan;
import br.com.szpbl.loanapi.exceptions.CustomerNotFoundException;
import br.com.szpbl.loanapi.exceptions.InvalidLoanException;
import br.com.szpbl.loanapi.exceptions.UnauthorizedException;
import br.com.szpbl.loanapi.repositories.CustomerRepository;
import br.com.szpbl.loanapi.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoanService {

    private final LoanMapper loanMapper;
    private LoanRepository loanRepository;
    private CustomerRepository customerRepository;

    public MessageResponseDTO generateLoan(LoanDTO loanDTO, Long id) throws Exception {

        LocalDate limitDate = LocalDate.now().plusMonths(3);
        Loan loan = loanMapper.toModel(loanDTO);
        boolean isTranchesNumberValid = loan.getTranches() >= 1 && loan.getTranches() <= 60;
        boolean isDateValid = loan.getFirstPayment().isBefore(limitDate) || loan.getFirstPayment().equals(limitDate);

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));

        if (!customer.isLoggedIn()) {
            throw new UnauthorizedException("Customer not logged in!");
        }

        if (isTranchesNumberValid && isDateValid) {
            Loan savedLoan = loanRepository.save(loan);
            customer.getLoans().add(savedLoan);
            customerRepository.save(customer);
        } else {
            String message = "";
            if (!isDateValid){
                message += " First payment must be before three months from today.";
            }
            if (!isTranchesNumberValid){
                message += " Tranches number must be between 1 and 60.";
            }
            throw new InvalidLoanException(message);
        }

        return MessageResponseDTO.builder().message(String.format("R$%.2f loan made for %s!", loanDTO.getLoanAmount(), customer.getName())).build();
    }


}
