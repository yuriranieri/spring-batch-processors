package com.springbatch.processadorscript.writer;

import com.springbatch.processadorscript.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorScriptWriterConfig {

    @Bean
    public ItemWriter<Cliente> processadorScriptWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }

}
