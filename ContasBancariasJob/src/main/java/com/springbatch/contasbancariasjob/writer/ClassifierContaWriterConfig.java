package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ClassifierContaWriterConfig {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classifierContaWriter(
            @Qualifier("clienteInvalidoContaWriter") FlatFileItemWriter<Conta> clienteInvalidoWriter,
            CompositeItemWriter<Conta> clienteValidoWriter) {
        return new ClassifierCompositeItemWriterBuilder<Conta>()
                .classifier(classifier(clienteInvalidoWriter, clienteValidoWriter)) // classifcador q vai ser usado
                // ele vai dizer writer vai ser aplciado dependendo da classificacao da conta
                .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classifier(
            FlatFileItemWriter<Conta> clienteInvalidoWriter,
            CompositeItemWriter<Conta> clienteValidoWriter) {
        return conta -> {
            if (Objects.isNull(conta.getTipo())) {
                return clienteInvalidoWriter;
            }

            return clienteValidoWriter;
        };
    }

}
