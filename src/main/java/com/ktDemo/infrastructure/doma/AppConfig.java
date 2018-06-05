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

@SingletonConfig
public class AppConfig implements Config {

    private static final AppConfig INSTANCE = new AppConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    private AppConfig() {

        Yaml yaml = new Yaml();
        DBConfig config = yaml.load(ClassLoader.getSystemResourceAsStream("application.yml"));

        dialect = new MysqlDialect();
        dataSource = new LocalTransactionDataSource(config.DB_URL, config.DB_USER, config.DB_PASS);
        //dataSource = new LocalTransactionDataSource("jdbc:mysql://localhost:3306/Spring_Training", "root", "qwerty");
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


    class DBConfig {
        String DB_URL;
        String DB_USER;
        String DB_PASS;
    }
}
