package com.br.finance.modules.despesa.dto;

import com.br.finance.modules.usuario.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class DespesaFilter implements Serializable {

  private static final long serialVersionUID = 5768142966656714645L;

  private Date dtInicial;
  private Date dtFinal;
  @JsonIgnore private Usuario usuario;
}
