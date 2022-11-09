package com.br.finance.modules.investimento.service;

import com.br.finance.modules.investimento.dto.InvestimentoDto;
import com.br.finance.modules.investimento.mapper.InvestimentoMapper;
import com.br.finance.modules.investimento.respository.InvestimentoRepository;
import com.br.finance.modules.usuario.service.UsuarioService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvestimentoService {
  private final InvestimentoRepository investimentoRepository;
  private final InvestimentoMapper investimentoMapper;
  private final UsuarioService usuarioService;

  public List<InvestimentoDto> buscar() {
    var usuario = usuarioService.getUsuario();
    return investimentoRepository.findByUsuario(usuario).stream()
        .map(investimento -> investimentoMapper.investimentoToDto(investimento))
        .collect(Collectors.toList());
  }

  public void deletar(Integer id) {
    investimentoRepository.deleteById(id);
  }

  public InvestimentoDto salvar(InvestimentoDto investimento) {
    var invest = investimentoMapper.dtoToInvestimento(investimento);
    invest.setUsuario(usuarioService.getUsuario());
    invest.setDtLancamento(LocalDateTime.now());
    invest = investimentoRepository.save(invest);
    return investimentoMapper.investimentoToDto(invest);
  }
}
