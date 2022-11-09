package com.br.finance.modules.investimento.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestimentoDto {

  private Integer id;
  private String descricao;
  private String entidade;

  private LocalDateTime dtLancamento;
  private BigDecimal valor;
  private BigDecimal perRecebido;
}
