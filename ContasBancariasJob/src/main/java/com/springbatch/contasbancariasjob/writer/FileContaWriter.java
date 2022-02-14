package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class FileContaWriter {

    @Bean
    public FlatFileItemWriter<Conta> fileItemWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("fileItemWriter")
                .resource(new FileSystemResource("./files/contas.txt"))
                .delimited()
                .delimiter("//")
                .names("tipo", "limite", "cliente")
                .build();
    }

}
