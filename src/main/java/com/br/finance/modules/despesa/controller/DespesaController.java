package com.br.finance.modules.despesa.controller;

import com.br.finance.modules.despesa.dto.DespesaDto;
import com.br.finance.modules.despesa.dto.DespesaFilter;
import com.br.finance.modules.despesa.entity.Despesa;
import com.br.finance.modules.despesa.service.DespesaService;
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
@RequestMapping("api/v1/despesa")
@CrossOrigin(origins = "*")
@Validated
public class DespesaController {

  private final DespesaService despesaService;

  @PostMapping(path = "/buscar")
  public List<DespesaDto> buscar(@Valid @RequestBody DespesaFilter filter) {
    return despesaService.buscar(filter);
  }

  @PostMapping
  public DespesaDto salvar(@RequestBody Despesa despesa) {
    return despesaService.salvar(despesa);
  }

  @DeleteMapping(path = "/{id}")
  public void deletar(@PathVariable Integer id) {
    despesaService.deletar(id);
  }
}
