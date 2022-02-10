package com.springbatch.contasbancariasjob.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoConta {

    PRATA(0.0, 3000.0),
    OURO(3001.0, 5000.0),
    PLATINA(5001.0, 10000.0),
    DIAMANTE(10000.0, Double.MAX_VALUE);

    private final Double valorInicial;
    private final Double valorFinal;

    TipoConta(Double valorInicial, Double valorFinal) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public static Optional<TipoConta> findByFaixaSalarial(Double faixaSalarial) {
        return Stream.of(values())
                .filter(conta -> faixaSalarial >= conta.getValorInicial() && faixaSalarial <= conta.getValorFinal())
                .findFirst();
    }
}
