package com.springbatch.contasbancariasjob.enums;

import java.util.Objects;
import java.util.stream.Stream;

public enum TipoConta {

    PRATA(0.0, 3000.0, 500.0),
    OURO(3001.0, 5000.0, 1000.0),
    PLATINA(5001.0, 10000.0, 2500.0),
    DIAMANTE(10001.0, Double.MAX_VALUE, 5000.0),
    INVALIDA(null, null, null);

    private final Double valorInicial;
    private final Double valorFinal;
    private final Double limtite;

    TipoConta(Double valorInicial, Double valorFinal, Double limtite) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.limtite = limtite;
    }

    public static TipoConta findByFaixaSalarial(Double faixaSalarial) {
        if (Objects.isNull(faixaSalarial)) {
            return INVALIDA;
        }

        return Stream.of(values())
                .filter(conta -> faixaSalarial >= conta.getValorInicial() && faixaSalarial <= conta.getValorFinal())
                .findFirst()
                .get();
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public Double getLimtite() {
        return limtite;
    }
}
