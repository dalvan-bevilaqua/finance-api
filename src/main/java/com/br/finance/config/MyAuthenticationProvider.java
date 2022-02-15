package com.br.finance.config;

import com.br.finance.modules.usuario.entity.Usuario;
import com.br.finance.modules.usuario.repository.UsuarioRepository;
import java.util.Collections;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

  @Autowired private UsuarioRepository usuarioRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    final UsernamePasswordAuthenticationToken upAuth =
        (UsernamePasswordAuthenticationToken) authentication;
    final String name = (String) authentication.getPrincipal();

    final String password = (String) upAuth.getCredentials();

    final String storedPassword =
        usuarioRepository
            .findByUsuario(name)
            .map(Usuario::getSenha)
            .orElseThrow(() -> new BadCredentialsException("Usuário ou senha inválidos"));

    if (Objects.equals(password, "") || !Objects.equals(password, storedPassword)) {
      throw new BadCredentialsException("Usuário ou senha inválidos");
    }

    final Object principal = authentication.getPrincipal();
    final UsernamePasswordAuthenticationToken result =
        new UsernamePasswordAuthenticationToken(
            principal, authentication.getCredentials(), Collections.emptyList());
    result.setDetails(authentication.getDetails());

    return result;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }
}
