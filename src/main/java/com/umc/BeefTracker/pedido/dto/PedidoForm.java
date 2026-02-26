package com.umc.BeefTracker.pedido.dto;

import java.time.LocalDate;

public record PedidoForm(
        Long fornecedor,
        Long peso,
        String observacoes,
        Double valor,
        Integer motorista,
        LocalDate dataEntrega
){

}
