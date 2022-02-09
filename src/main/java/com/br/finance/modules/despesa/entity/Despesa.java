package com.br.finance.modules.despesa.entity;

import com.br.finance.modules.configuracoes.entity.Grupo;
import com.br.finance.modules.despesa.enums.OcorrenciaDespesaEnum;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "despesa")
public class Despesa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descricao;

  private Date dtLancamento;
  private Date dtDespesa;

  private OcorrenciaDespesaEnum tipoDespesa;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idGrupo", insertable = false, updatable = false)
  private Grupo grupo;
}
