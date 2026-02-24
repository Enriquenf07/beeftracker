package com.umc.BeefTracker.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record UsuarioSecurity (Usuario user) implements UserDetails {
        @Override
        public String getUsername() { return user.email(); }

        @Override
        public String getPassword() { return user.password(); }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return new ArrayList<>();
        }
    }
