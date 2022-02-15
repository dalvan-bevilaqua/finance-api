package com.br.finance.modules.despesa.predicate;

import com.br.finance.modules.despesa.dto.DespesaFilter;
import com.br.finance.modules.despesa.entity.QDespesa;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DespesaPredicate {

  public static Predicate despesaPredicate(DespesaFilter despesaFilter) {

    BooleanBuilder predicate = new BooleanBuilder();
    QDespesa qDespesa = QDespesa.despesa;

    predicate.and(qDespesa.usuario.id.eq(despesaFilter.getUsuario().getId()));
    predicate.and(
        qDespesa.dtDespesa.between(
            LocalDateTime.of(despesaFilter.getAno(), Month.of(despesaFilter.getMes() + 1), 1, 0, 0),
            LocalDateTime.of(
                despesaFilter.getAno(),
                Month.of(despesaFilter.getMes() + 1),
                buscarUltimoDiaDoMes(despesaFilter),
                23,
                59)));

    return predicate;
  }

  private static int buscarUltimoDiaDoMes(DespesaFilter despesaFilter) {
    Calendar instance = Calendar.getInstance();
    instance.set(Calendar.MONTH, despesaFilter.getMes());
    instance.set(Calendar.YEAR, despesaFilter.getAno());

    return instance.getActualMaximum(Calendar.DAY_OF_MONTH);
  }
}
