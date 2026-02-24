package com.umc.BeefTracker.auth.repository;

import com.umc.BeefTracker.auth.model.Usuario;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository {
    public Usuario findByEmail(String email);
}
