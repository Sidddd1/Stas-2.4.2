package ru.stas.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.script.ScriptException;
import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class DataInitService {


    private final DataSource dataSource;

    public DataInitService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void populateSampleData() throws ScriptException, SQLException {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("dataset.sql"));

        populator.populate(dataSource.getConnection());

    }
}
