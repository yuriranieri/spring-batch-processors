package com.springbatch.contasbancariasjob.reader;

import com.springbatch.contasbancariasjob.dominio.Cliente;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ContaBancariaReader {

    @Bean
    public JdbcPagingItemReader<Cliente> clienteItemReader(@Qualifier("appDataSource") DataSource dataSource,
                                                           PagingQueryProvider queryProvider) {
        return new JdbcPagingItemReaderBuilder<Cliente>()
                .name("clienteContaBancariaReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .pageSize(1)
                .rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
        var queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("*");
        queryProvider.setFromClause("from cliente");
        queryProvider.setSortKey("email");
        return queryProvider;
    }

}
