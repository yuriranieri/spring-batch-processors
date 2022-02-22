package com.springbatch.contasbancariasjob.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.springbatch.contasbancariasjob.enums.TipoConta.DIAMANTE;
import static com.springbatch.contasbancariasjob.enums.TipoConta.INVALIDA;
import static com.springbatch.contasbancariasjob.enums.TipoConta.OURO;
import static com.springbatch.contasbancariasjob.enums.TipoConta.PLATINA;
import static com.springbatch.contasbancariasjob.enums.TipoConta.PRATA;
import static com.springbatch.contasbancariasjob.enums.TipoConta.findByFaixaSalarial;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoContaTest {

    @Test
    void whenFindByFaixaSalarial_returnINVALIDA() {
        TipoConta invalida = INVALIDA;
        TipoConta response = findByFaixaSalarial(null);

        assertAll(
                () -> assertEquals(invalida, response),
                () -> assertEquals(invalida.getLimtite(), response.getLimtite())
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 1000.0, 3000.0})
    void whenFindByFaixaSalarial_returnPRATA(Double faixaSalarial) {
        TipoConta response = findByFaixaSalarial(faixaSalarial);
        TipoConta prata = PRATA;

        assertAll(
                () -> assertEquals(prata, response),
                () -> assertEquals(prata.getLimtite(), response.getLimtite())
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {3001.0, 4000.0, 5000.0})
    void whenFindByFaixaSalarial_returnOURO(Double faixaSalarial) {
        TipoConta response = findByFaixaSalarial(faixaSalarial);
        TipoConta ouro = OURO;

        assertAll(
                () -> assertEquals(ouro, response),
                () -> assertEquals(ouro.getLimtite(), response.getLimtite())
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {5001.0, 7500.0, 10000.0})
    void whenFindByFaixaSalarial_returnPLATINA(Double faixaSalarial) {
        TipoConta response = findByFaixaSalarial(faixaSalarial);
        TipoConta platina = PLATINA;

        assertAll(
                () -> assertEquals(platina, response),
                () -> assertEquals(platina.getLimtite(), response.getLimtite())
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {10001.0, 1000000.0, Double.MAX_VALUE})
    void whenFindByFaixaSalarial_returnDIAMANTE(Double faixaSalarial) {
        TipoConta response = findByFaixaSalarial(faixaSalarial);
        TipoConta diamante = DIAMANTE;

        assertAll(
                () -> assertEquals(diamante, response),
                () -> assertEquals(diamante.getLimtite(), response.getLimtite())
        );
    }

}