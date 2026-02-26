package com.umc.BeefTracker.vendas.interfaces;

public interface IVendaService {
    void cadastrar();
    void deletar(Integer id);
    void concluir(Integer id);
    void status(Integer id);
    void getMapaDeCalor(Integer id);


}
