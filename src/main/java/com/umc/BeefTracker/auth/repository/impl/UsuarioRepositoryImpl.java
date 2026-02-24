package com.umc.BeefTracker.auth.repository.impl;

import com.umc.BeefTracker.auth.model.Usuario;
import com.umc.BeefTracker.auth.repository.UsuarioRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        return jdbcTemplate.queryForObject(sql, usuarioRowMapper(), email);
    }

    private RowMapper<Usuario> usuarioRowMapper() {
        return (rs, rowNum) -> new Usuario(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("nome"),
                rs.getString("senha")
        );
    }
}
