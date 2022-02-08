package com.br.finance.modules.despesa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/despesa")
public class DespesaController {

  @GetMapping("/buscar")
  public String buscar() {
    return "Working";
  }
}