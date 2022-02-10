package com.springbatch.contasbancariasjob.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoContaTest {

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 1000.0, 3000.0})
    void whenfindByFaixaSalarial_returnPRATA(Double faixaSalarial) {
        assertEquals(TipoConta.PRATA, TipoConta.findByFaixaSalarial(faixaSalarial));
    }

    @ParameterizedTest
    @ValueSource(doubles = {3001.0, 4000.0, 5000.0})
    void whenfindByFaixaSalarial_returnOURO(Double faixaSalarial) {
        assertEquals(TipoConta.OURO, TipoConta.findByFaixaSalarial(faixaSalarial));
    }

    @ParameterizedTest
    @ValueSource(doubles = {5001.0, 7500.0, 10000.0})
    void whenfindByFaixaSalarial_returnPLATINA(Double faixaSalarial) {
        assertEquals(TipoConta.PLATINA, TipoConta.findByFaixaSalarial(faixaSalarial));
    }

    @ParameterizedTest
    @ValueSource(doubles = {10001.0, 1000000.0, Double.MAX_VALUE})
    void whenfindByFaixaSalarial_returnDIAMANTE(Double faixaSalarial) {
        assertEquals(TipoConta.DIAMANTE, TipoConta.findByFaixaSalarial(faixaSalarial));
    }

}