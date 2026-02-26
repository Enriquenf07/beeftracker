package com.umc.BeefTracker.vendas.model;

import com.umc.BeefTracker.pedido.model.TipoDeCorte;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoteFinal {
    private Long tipoDeCorte;
    private LocalDate dataAbate;
    private Long id;
    private Double integridadeTermica;
    private LocalDate dataValidade;
    private Integer loteBruto;

    public LoteFinal(Long id, Long tipo, LocalDate dataAbate) {
        this.id = id;
        this.tipoDeCorte = tipo;
        this.dataAbate = dataAbate;
        this.integridadeTermica = 1.0;
    }
    public LocalDate calcularValidadeEstimada(TipoDeCorte tipoDeCorte) {
        long diasValidade = tipoDeCorte.validadePadrao();

        long diasAjustados = Math.round(diasValidade * integridadeTermica);

        return dataAbate.plusDays(diasAjustados);
    }

    public boolean atingiuAlertaGiroRapido() {
        LocalDate dataAtual = LocalDate.now();
        long diasRestantes = ChronoUnit.DAYS.between(dataAtual, dataValidade);
        long diasTotais = ChronoUnit.DAYS.between(dataAbate, dataValidade);
        if (diasTotais <= 0) return false;
        double percentualDeSaida = 100.0 - ((diasRestantes * 100.0) / diasTotais);
        return percentualDeSaida > 70.0; // habilitar por configuração
    }
}
