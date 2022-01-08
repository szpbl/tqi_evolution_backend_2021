package br.com.szpbl.loanapi.dto.mapper;

import br.com.szpbl.loanapi.dto.request.LoanDTO;
import br.com.szpbl.loanapi.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(target = "firstPayment", source = "firstPayment", dateFormat = "dd-MM-yyyy")
    Loan toModel(LoanDTO loanDTO);

    LoanDTO toDTO(Loan loan);
}
