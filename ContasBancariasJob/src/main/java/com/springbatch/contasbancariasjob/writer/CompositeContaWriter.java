package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompositeContaWriter {

    @Bean
    public CompositeItemWriter<Conta> contaCompositeItemWriter(FlatFileItemWriter<Conta> fileItemWriter,
                                                               JdbcBatchItemWriter<Conta> contaJdbcBatchItemWriter) {
        return new CompositeItemWriterBuilder<Conta>()
                .delegates(fileItemWriter, contaJdbcBatchItemWriter)
                .build();
    }

}
