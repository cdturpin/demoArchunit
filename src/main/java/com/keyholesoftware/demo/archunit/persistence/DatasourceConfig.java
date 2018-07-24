package com.keyholesoftware.demo.archunit.persistence;

import javax.sql.DataSource;

public interface DatasourceConfig {
    public DataSource dataSource();
}