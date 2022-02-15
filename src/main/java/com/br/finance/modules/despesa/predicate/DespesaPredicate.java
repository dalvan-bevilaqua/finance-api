package com.br.finance.modules.despesa.predicate;

import com.br.finance.modules.despesa.dto.DespesaFilter;
import com.br.finance.modules.despesa.entity.QDespesa;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DespesaPredicate {

  public static Predicate despesaPredicate(DespesaFilter despesaFilter) {

    BooleanBuilder predicate = new BooleanBuilder();
    QDespesa qDespesa = QDespesa.despesa;
    predicate.and(qDespesa.usuario.id.eq(despesaFilter.getUsuario().getId()));

    return predicate;
  }
}
