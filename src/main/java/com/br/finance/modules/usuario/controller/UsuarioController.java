package com.br.finance.modules.usuario.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

  @PostMapping(path = "/autenticar")
  public String autenticar() {
    return "autenticado";
  }
}
