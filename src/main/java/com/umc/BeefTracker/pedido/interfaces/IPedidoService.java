package com.umc.BeefTracker.pedido.interfaces;

import com.umc.BeefTracker.pedido.dto.PedidoForm;

import java.util.List;

public interface IPedidoService {
    void novoPedido(PedidoForm pedido);

    void cancelarPedido(Integer id);

    void concluirPedido(Integer id);

    List<Object> pesquisar();
}
