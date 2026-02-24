package com.umc.BeefTracker.auth.service;

import com.umc.BeefTracker.auth.model.Usuario;
import com.umc.BeefTracker.auth.model.UsuarioSecurity;
import com.umc.BeefTracker.auth.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public LoginService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findByEmail(username);

        return new UsuarioSecurity(user);
    }
}
