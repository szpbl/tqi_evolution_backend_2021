package br.com.szpbl.loanapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private Long id;

    @NotEmpty
    private double loanAmount;

    @NotEmpty
    private LocalDate firstPayment;

    @NotEmpty
    @Min(1)
    private int tranches;

}
