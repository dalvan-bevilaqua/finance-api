package com.br.finance.modules.despesa.service;

import com.br.finance.modules.despesa.dto.DespesaDto;
import com.br.finance.modules.despesa.dto.DespesaFilter;
import com.br.finance.modules.despesa.entity.Despesa;
import com.br.finance.modules.despesa.mapper.DespesaMapper;
import com.br.finance.modules.despesa.predicate.DespesaPredicate;
import com.br.finance.modules.despesa.repository.DespesaRepository;
import com.br.finance.modules.usuario.service.UsuarioService;
import com.querydsl.core.types.Predicate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DespesaService {

  private final DespesaRepository despesaRepository;
  private final DespesaMapper despesaMapper;
  private final UsuarioService usuarioService;

  @Transactional
  public List<DespesaDto> buscar(DespesaFilter filter) {
    filter.setUsuario(usuarioService.getUsuario());
    Predicate predicate = DespesaPredicate.despesaPredicate(filter);

    var despesaList = new ArrayList<DespesaDto>();
    despesaRepository
        .findAll(predicate)
        .forEach(
            despesa -> {
              despesaList.add(despesaMapper.toDto(despesa));
            });
    return despesaList;
  }

  @Transactional
  public DespesaDto salvar(Despesa despesa) {
    despesa.setUsuario(usuarioService.getUsuario());
    return despesaMapper.toDto(despesaRepository.save(despesa));
  }

  public void deletar(Integer id) {
    despesaRepository.deleteById(id);
  }
}
