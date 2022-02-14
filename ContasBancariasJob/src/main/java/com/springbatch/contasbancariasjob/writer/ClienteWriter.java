package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClienteWriter {

    @Bean
    public ItemWriter<Cliente> clienteItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
