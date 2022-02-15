package com.br.finance.modules.usuario.service;

import com.br.finance.modules.usuario.entity.Usuario;
import com.br.finance.modules.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  public Usuario getUsuario() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return usuarioRepository
        .findByUsuario(auth.getName())
        .orElseThrow(() -> new BadCredentialsException("Usuário ou senha inválidos"));
  }
}
