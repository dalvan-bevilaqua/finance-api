package com.br.finance.modules.despesa.mapper;

import com.br.finance.modules.despesa.dto.DespesaDto;
import com.br.finance.modules.despesa.entity.Despesa;
import org.mapstruct.Mapper;

@Mapper
public interface DespesaMapper {
  DespesaDto toDto(Despesa source);
}
