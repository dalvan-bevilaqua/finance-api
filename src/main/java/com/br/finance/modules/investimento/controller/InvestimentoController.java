package com.br.finance.modules.investimento.controller;

import com.br.finance.modules.investimento.dto.InvestimentoDto;
import com.br.finance.modules.investimento.dto.InvestimentoFilter;
import com.br.finance.modules.investimento.service.InvestimentoService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/investimento")
@CrossOrigin(origins = "*")
@Validated
public class InvestimentoController {

  private final InvestimentoService investimentoService;

  @PostMapping(path = "/buscar")
  public List<InvestimentoDto> buscar() {
    return investimentoService.buscar();
  }

  @PostMapping
  public InvestimentoDto salvar(@RequestBody InvestimentoDto dto) {
    return investimentoService.salvar(dto);
  }

  @DeleteMapping(path = "/{id}")
  public void deletar(@PathVariable Integer id) {
    investimentoService.deletar(id);
  }
}
