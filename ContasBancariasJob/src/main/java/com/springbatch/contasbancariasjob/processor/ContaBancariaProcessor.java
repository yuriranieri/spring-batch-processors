package com.springbatch.contasbancariasjob.processor;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import com.springbatch.contasbancariasjob.dominio.Conta;
import com.springbatch.contasbancariasjob.enums.TipoConta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.springbatch.contasbancariasjob.enums.TipoConta.INVALIDA;

@Component
public class ContaBancariaProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) throws Exception {
        TipoConta tipoConta = TipoConta.findByFaixaSalarial(cliente.getFaixaSalarial());

        boolean tipoContaIsInvalida = Objects.equals(tipoConta.name(), INVALIDA.name());
        if (tipoContaIsInvalida) {
            return new Conta(cliente.getEmail());
        }

        return new Conta(tipoConta.name(), tipoConta.getLimtite(), cliente.getEmail());
    }

}
