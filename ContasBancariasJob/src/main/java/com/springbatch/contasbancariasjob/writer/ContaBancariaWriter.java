package com.springbatch.contasbancariasjob.writer;

import com.springbatch.contasbancariasjob.dominio.Conta;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ContaBancariaWriter {

    @Bean
    public JdbcBatchItemWriter<Conta> contaItemWriter(@Qualifier("appDataSource") DataSource dataSource) {
        // jdbcBatch pois executa escrita em lote obtem inserts de tds objs a serem escritos e executam em uma transacao
        return new JdbcBatchItemWriterBuilder<Conta>()
                .dataSource(dataSource)
                .sql("insert into conta (tipo, limite, cliente_id) values (?, ?, ?)")
                .itemPreparedStatementSetter(prepareStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter<Conta> prepareStatementSetter() {
        return (item, ps) -> {
            ps.setString(1, item.getTipo());
            ps.setDouble(2, item.getLimite());
            ps.setString(3, item.getCliente());
        };
    }

}
