package accident.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * DataConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/10/2020
 */
@Configuration
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("accident.repository")
@EnableTransactionManagement
public class DataConfig {
    /**
     * Method  to get pool of connection.
     *
     * @param driver   a driver
     * @param url      a url
     * @param username a username
     * @param password a password
     * @return pool
     */
    @Bean
    public DataSource ds(@Value("${jdbc.driver}") final String driver,
                         @Value("${jdbc.url}") final String url,
                         @Value("${jdbc.username}") final String username,
                         @Value("${jdbc.password}") final String password) {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    /**
     * Method to create JPA EntityManagerFactory.
     *
     * @param ds connect
     * @return factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource ds) {
        final HibernateJpaVendorAdapter adapter =
                new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        final LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("accident.model");
        factory.setDataSource(ds);
        return factory;
    }

    /**
     * Method to get transaction manager.
     *
     * @param entity manager of entity
     * @return manager
     */
    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entity) {
        final JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entity);
        return txManager;
    }
}
