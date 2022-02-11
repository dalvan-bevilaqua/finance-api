package com.br.finance.modules.despesa.service;

import com.br.finance.modules.configuracoes.entity.Grupo;
import com.br.finance.modules.despesa.dto.DespesaDto;
import com.br.finance.modules.despesa.dto.DespesaFilter;
import com.br.finance.modules.despesa.entity.Despesa;
import com.br.finance.modules.despesa.enums.OcorrenciaDespesaEnum;
import com.br.finance.modules.despesa.mapper.DespesaMapper;
import com.br.finance.modules.despesa.repository.DespesaRepository;
import com.br.finance.modules.usuario.entity.Usuario;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DespesaService {
  private final DespesaRepository despesaRepository;
  private final DespesaMapper despesaMapper;

  @Transactional
  public List<DespesaDto> buscar(DespesaFilter filter) {
    return despesaRepository.findAll().stream()
        .map(despesa -> despesaMapper.toDto(despesa))
        .collect(Collectors.toList());
  }

  @Transactional
  public Despesa salvar(Despesa despesa) {
    return despesaRepository.save(
        Despesa.builder()
            .dtDespesa(LocalDateTime.now())
            .dtLancamento(LocalDateTime.now())
            .grupo(Grupo.builder().id(1).build())
            .ocorrenciaDespesa(OcorrenciaDespesaEnum.ESPORADICA)
            .descricao("teste")
            .usuario(Usuario.builder().id(1).build())
            .build());
  }
}
