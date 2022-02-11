package com.br.finance.modules.usuario.repository;

import com.br.finance.modules.usuario.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByUsuario(String usuario);
}
