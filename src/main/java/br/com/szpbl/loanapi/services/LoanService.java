package br.com.szpbl.loanapi.services;

import br.com.szpbl.loanapi.dto.mapper.LoanMapper;
import br.com.szpbl.loanapi.dto.request.LoanDTO;
import br.com.szpbl.loanapi.dto.response.LoanDetailResponseDTO;
import br.com.szpbl.loanapi.dto.response.LoanResponseDTO;
import br.com.szpbl.loanapi.entities.Customer;
import br.com.szpbl.loanapi.entities.Loan;
import br.com.szpbl.loanapi.exceptions.CustomerNotFoundException;
import br.com.szpbl.loanapi.exceptions.InvalidLoanException;
import br.com.szpbl.loanapi.exceptions.UnauthorizedException;
import br.com.szpbl.loanapi.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoanService {

    private final LoanMapper loanMapper;
    private LoanRepository loanRepository;
    private CustomerService customerService;

    public LoanResponseDTO generateLoan(LoanDTO loanDTO, Long id) throws Exception {

        LocalDate limitDate = LocalDate.now().plusMonths(3);
        Loan loan = loanMapper.toModel(loanDTO);
        LocalDate firstPaymentDate = loan.getFirstPayment();
        boolean isTranchesNumberValid = loan.getTranches() >= 1 && loan.getTranches() <= 60;
        boolean isDateValid = loan.getFirstPayment().isBefore(limitDate) || loan.getFirstPayment().equals(limitDate);
        Customer customer = customerService.findCustomerById(id);

        if (!customer.isLoggedIn()) {
            throw new UnauthorizedException("Customer not logged in!");
        }

        if (isTranchesNumberValid && isDateValid) {
            customer.getLoans().add(loan);
            loanRepository.save(loan);
        } else {
            String message = "";
            if (!isDateValid) {
                message += " First payment must be before three months from today.";
            }
            if (!isTranchesNumberValid) {
                message += " Tranches number must be between 1 and 60.";
            }
            throw new InvalidLoanException(message);
        }

        return new LoanResponseDTO(loan.getId(), loanDTO.getLoanAmount(), firstPaymentDate, loanDTO.getTranches(), loanDTO.getCustomerId());
    }

    public List<LoanDTO> listLoans(Long id) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomerById(id);
        List<Loan> loans = customer.getLoans();

        return loans.stream().map(loanMapper::toDTO).collect(Collectors.toList());
    }

    public LoanDetailResponseDTO getLoanDetail(Long id) throws CustomerNotFoundException {

        Loan loan = loanRepository.getById(id);
        LocalDate firstPaymentDate = loan.getFirstPayment();
        LoanDTO loanDTO = loanMapper.toDTO(loan);

        Customer customer = customerService.findCustomerById(loanDTO.getCustomerId());

        return new LoanDetailResponseDTO(loanDTO.getId(), loanDTO.getLoanAmount(), firstPaymentDate, loanDTO.getTranches(), customer.getEmail(), customer.getIncome());
    }




}
