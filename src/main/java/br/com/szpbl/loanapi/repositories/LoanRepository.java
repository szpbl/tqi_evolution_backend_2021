package br.com.szpbl.loanapi.repositories;

import br.com.szpbl.loanapi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
