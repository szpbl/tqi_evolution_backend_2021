package br.com.szpbl.loanapi.dto.response;

import br.com.szpbl.loanapi.dto.request.LoanDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListLoanResponseDTO {

    private Long clientId;
    private String clientName;
    private List<LoanDTO> loans;
}
