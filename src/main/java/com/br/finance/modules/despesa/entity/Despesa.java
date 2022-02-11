package com.br.finance.modules.despesa.entity;

import com.br.finance.modules.configuracoes.entity.Grupo;
import com.br.finance.modules.despesa.enums.OcorrenciaDespesaEnum;
import com.br.finance.modules.usuario.entity.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
public class Despesa implements Serializable {

  private static final long serialVersionUID = -269697680109030897L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descricao;

  private LocalDateTime dtLancamento;
  private LocalDateTime dtDespesa;
  private BigDecimal valor;

  private OcorrenciaDespesaEnum ocorrenciaDespesa;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idGrupo")
  private Grupo grupo;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUsuario")
  private Usuario usuario;
}
