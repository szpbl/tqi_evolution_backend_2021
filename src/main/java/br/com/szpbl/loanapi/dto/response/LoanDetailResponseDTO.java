package br.com.szpbl.loanapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetailResponseDTO {

    private Long loanId;

    private double amount;

    private LocalDate firstPayment;

    private int tranches;

    private String email;

    private double income;

}
