package com.ktDemo.infrastructure.doma;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.yaml.snakeyaml.Yaml;

import javax.sql.DataSource;
import java.util.Map;

@SingletonConfig
public class AppConfig implements Config {

    private static final AppConfig INSTANCE = new AppConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    private AppConfig() {

        Yaml yaml = new Yaml();
        Map configMap = yaml.load(ClassLoader.getSystemResourceAsStream("application.yml"));
        final String DB_URL = (String) configMap.get("url");
        final String DB_USER = (String) configMap.get("username");
        final String DB_PASS = (String) configMap.get("password");

        dialect = new MysqlDialect();
        dataSource = new LocalTransactionDataSource(DB_URL, DB_USER, DB_PASS);
        transactionManager = new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static AppConfig singleton() {
        return INSTANCE;
    }

}
