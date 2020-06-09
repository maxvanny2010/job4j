package accident.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * HbmConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/9/2020
 */
@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class HbmConfig {
    /**
     * Method to register pool.
     *
     * @param driver   a driver
     * @param url      a url
     * @param username a username
     * @param password a password
     * @return data source
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
     * Method to set and to get session factory.
     *
     * @param dialect a dialect
     * @param ds      data source
     * @return session factory.
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory(
            @Value("${hibernate.dialect}") final String dialect,
            final DataSource ds) {
        final LocalSessionFactoryBean session = new LocalSessionFactoryBean();
        session.setDataSource(ds);
        session.setPackagesToScan("accident.model");
        final Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", dialect);
        session.setHibernateProperties(prop);
        return session;
    }

    /**
     * Method to set a platform manager.
     *
     * @param sf session factory
     * @return manager
     **/
    @Bean
    public PlatformTransactionManager ptm(final SessionFactory sf) {
        final HibernateTransactionManager htm =
                new HibernateTransactionManager();
        htm.setSessionFactory(sf);
        return htm;
    }
}
