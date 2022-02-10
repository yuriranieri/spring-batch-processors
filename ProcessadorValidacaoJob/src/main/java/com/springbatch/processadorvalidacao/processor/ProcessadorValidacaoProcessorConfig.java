package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

    private final Set<String> emails = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> procesadorValidacaoProcessor() throws Exception {
        return new CompositeItemProcessorBuilder<Cliente, Cliente>() // recebe e devolve cliente
                .delegates(beanValidatingItemProcessor(), emailValidatingItemProcessor())
                // delega o processamento para seus város processadores
                .build();
    }

    private BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
        processor.setFilter(true); // filtra os inválidos
        processor.afterPropertiesSet(); // seta propriedades desse processor
        return processor;
    }

    private ValidatingItemProcessor<Cliente> emailValidatingItemProcessor() {
        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>(); // validacao customizada
        processor.setValidator(validator());
        processor.setFilter(true); // filtra os inválidos
        return processor;
    }

    private Validator<Cliente> validator() {
        return cliente -> {
            String clienteEmail = cliente.getEmail();
            if (emails.contains(clienteEmail)) {
                throw new ValidationException(format("O cliente %s já foi processado", clienteEmail));
            }
            emails.add(clienteEmail);
        };
    }

}
