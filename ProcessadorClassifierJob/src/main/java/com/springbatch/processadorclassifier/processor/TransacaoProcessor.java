package com.springbatch.processadorclassifier.processor;

import com.springbatch.processadorclassifier.dominio.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        System.out.printf("%nAplicando as regras de negócio na transação %s%n", transacao.getId());
        return transacao;
    }
}
