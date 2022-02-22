package com.springbatch.contasbancariasjob.step;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
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
                          ClassifierCompositeItemWriter<Conta> writer,
                          @Qualifier("clienteInvalidoContaWriter") FlatFileItemWriter<Conta> clienteInvalidoWriter,
                          @Qualifier("fileItemWriter") FlatFileItemWriter<Conta> clienteValidoWriter) {
        return stepBuilderFactory.get("stepConta")
                .<Cliente, Conta>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .stream(clienteInvalidoWriter)
                .stream(clienteValidoWriter)
                .build();
    }

}
