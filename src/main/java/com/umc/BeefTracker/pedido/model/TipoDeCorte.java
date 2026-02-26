package com.umc.BeefTracker.pedido.model;

public record TipoDeCorte(
        Long id,
        String descricao,
        Integer temperaturaMax,
        Integer validadePadrao
) { }
