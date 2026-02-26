package com.umc.BeefTracker.pedido.model;

public record LoteBruto(
        Long id,
        Integer fornecedor,
        Double peso,
        String observacoes
) {

}
