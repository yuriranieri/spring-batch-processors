package com.springbatch.contasbancariasjob.processor;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import com.springbatch.contasbancariasjob.dominio.Conta;
import com.springbatch.contasbancariasjob.enums.TipoConta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ContaBancariaProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) throws Exception {
        TipoConta tipoConta = TipoConta.findByFaixaSalarial(cliente.getFaixaSalarial());
        return new Conta(tipoConta.name(), tipoConta.getLimtite(), cliente.getEmail());
    }

}
