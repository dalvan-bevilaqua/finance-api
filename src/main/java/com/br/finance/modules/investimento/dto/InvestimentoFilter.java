package com.br.finance.modules.investimento.dto;

import com.br.finance.modules.usuario.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvestimentoFilter implements Serializable {

  private static final long serialVersionUID = 5768142966656714645L;

  @NotEmpty(message = "Mês é obrigatório")
  private Integer mes;
  @NotEmpty(message = "Ano é obrigatório")
  private Integer ano;
  @JsonIgnore private Usuario usuario;
}
