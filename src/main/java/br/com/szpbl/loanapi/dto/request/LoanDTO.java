package br.com.szpbl.loanapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private Long id;

    @NotNull
    private double loanAmount;

    @NotNull
    private String firstPayment;

    @NotNull
    @Min(1)
    private int tranches;

    @NotNull
    private Long customerId;


}
