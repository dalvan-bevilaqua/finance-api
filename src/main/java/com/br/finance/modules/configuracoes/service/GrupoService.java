package com.br.finance.modules.configuracoes.service;

import com.br.finance.modules.configuracoes.dto.GrupoDto;
import com.br.finance.modules.configuracoes.entity.Grupo;
import com.br.finance.modules.configuracoes.mapper.GrupoMapper;
import com.br.finance.modules.configuracoes.repository.GrupoRepository;
import com.br.finance.modules.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GrupoService {
  private final GrupoRepository grupoRepository;

  private final GrupoMapper grupoMapper;
  private final UsuarioService usuarioService;

  public GrupoDto salvar(Grupo grupo) {
    grupo.setUsuario(usuarioService.getUsuario());
    return grupoMapper.toGrupoDto(grupoRepository.save(grupo));
  }
}
