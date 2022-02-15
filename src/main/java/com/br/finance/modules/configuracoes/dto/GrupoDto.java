package com.br.finance.modules.configuracoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoDto {

  private Integer id;

  private String descricao;
  private String cor;
}
