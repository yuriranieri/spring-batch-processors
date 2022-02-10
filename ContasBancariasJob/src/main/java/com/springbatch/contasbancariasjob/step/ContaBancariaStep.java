package com.springbatch.contasbancariasjob.step;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaBancariaStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepCliente(ItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
        return stepBuilderFactory.get("stepCliente")
                .<Cliente, Cliente>chunk(100)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public Step stepConta(ItemReader<Cliente> reader,
                          ItemProcessor<Cliente, Conta> processor,
                          ItemWriter<Conta> writer) {
        return stepBuilderFactory.get("stepConta")
                .<Cliente, Conta>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
