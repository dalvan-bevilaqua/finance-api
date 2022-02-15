package com.br.finance.modules.despesa.repository;

import com.br.finance.modules.despesa.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DespesaRepository
    extends JpaRepository<Despesa, Integer>, QuerydslPredicateExecutor<Despesa> {}
