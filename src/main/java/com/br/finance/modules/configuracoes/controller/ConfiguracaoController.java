package com.br.finance.modules.configuracoes.controller;

import com.br.finance.modules.configuracoes.dto.GrupoDto;
import com.br.finance.modules.configuracoes.entity.Grupo;
import com.br.finance.modules.configuracoes.service.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/configuracao")
@CrossOrigin(origins = "*")
public class ConfiguracaoController {

  private final GrupoService grupoService;

  @PostMapping(path = "/salvar-grupo")
  public GrupoDto salvarGrupo(@RequestBody Grupo grupo) {
    return grupoService.salvar(grupo);
  }
}
