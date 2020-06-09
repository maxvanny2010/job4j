package accident.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * JdbcConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/9/2020
 */
@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class JdbcConfig {
    /**
     * Method to get properties jdbc connect.
     *
     * @param driver   driver
     * @param url      url
     * @param username username
     * @param password password
     * @return properties
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
     * Method to create jdbc template.
     *
     * @param ds data source
     * @return a jdbc template
     */
    @Bean
    public JdbcTemplate jdbc(final DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
