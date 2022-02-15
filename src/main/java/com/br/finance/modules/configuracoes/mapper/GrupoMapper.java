package com.br.finance.modules.configuracoes.mapper;

import com.br.finance.modules.configuracoes.dto.GrupoDto;
import com.br.finance.modules.configuracoes.entity.Grupo;
import org.mapstruct.Mapper;

@Mapper
public interface GrupoMapper {
  GrupoDto toGrupoDto(Grupo source);
}
