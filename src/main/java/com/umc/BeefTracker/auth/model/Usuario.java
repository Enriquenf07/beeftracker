package com.umc.BeefTracker.auth.model;


public record Usuario(
        Long id,
        String email,
        String nome,
        String password
) {}
