package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

    @Bean
    public ItemProcessor<Cliente, Cliente> procesadorValidacaoProcessor() {
        // TODO: Implementar a lógica aqui...
        return cliente -> cliente;
    }

}
