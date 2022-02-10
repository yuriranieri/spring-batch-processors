package com.springbatch.processadorclassifier.processor;

import com.springbatch.processadorclassifier.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings({"rawtypes", "unchecked"})
public class ProcessadorClassifierProcessorConfig {

    @Bean
    public ItemProcessor processadorClassifierProcessor() {
        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classifier())
                .build();
    }

    private Classifier classifier() {
        return (Classifier<Object, ItemProcessor>) obj -> {
            if (obj instanceof Cliente)
                return new ClienteProcessor();
            else
                return new TransacaoProcessor();
        };
    }

}
