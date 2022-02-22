package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class ClienteInvalidoWriter {

    @Bean
    public FlatFileItemWriter<Conta> clienteInvalidoContaWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("clienteInvalidoWriter")
                .resource(new FileSystemResource("./files/clientesInvalidos"))
                .delimited()
                .names("cliente")
                .build();
    }

}
