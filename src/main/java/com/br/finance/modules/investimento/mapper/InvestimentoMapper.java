package com.br.finance.modules.investimento.mapper;

import com.br.finance.modules.investimento.dto.InvestimentoDto;
import com.br.finance.modules.investimento.entity.Investimento;
import org.mapstruct.Mapper;

@Mapper
public interface InvestimentoMapper {
  Investimento dtoToInvestimento(InvestimentoDto investimentoDto);

  InvestimentoDto investimentoToDto(Investimento investimento);
}
