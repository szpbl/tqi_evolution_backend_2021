package br.com.szpbl.loanapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {

    private Long id;

    private double loanAmount;

    private LocalDate firstPayment;

    private int tranches;

    private Long customerId;
}