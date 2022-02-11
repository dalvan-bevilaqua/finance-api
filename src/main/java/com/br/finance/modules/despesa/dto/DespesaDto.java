package com.br.finance.modules.despesa.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class DespesaDto implements Serializable {

  private Integer id;
  private String descricao;
  private String dtLancamento;
  private String dtDespesa;
  private BigDecimal valor;

  // private OcorrenciaDespesaEnum ocorrenciaDespesa;
  // private Grupo grupo;
}
