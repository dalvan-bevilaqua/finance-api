package com.br.finance.modules.investimento.respository;

import com.br.finance.modules.investimento.entity.Investimento;
import com.br.finance.modules.usuario.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InvestimentoRepository
    extends JpaRepository<Investimento, Integer>, QuerydslPredicateExecutor<Investimento> {
  List<Investimento> findByUsuario(Usuario usuario);
}
