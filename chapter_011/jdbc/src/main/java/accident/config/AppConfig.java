package accident.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

/**
 * AppConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Configuration
@ComponentScan("accident")
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class AppConfig {
    /**
     * field a environment.
     */
    private final Environment env;

    /**
     * Constructor.
     *
     * @param aEnv a environment
     */
    public AppConfig(final Environment aEnv) {
        this.env = aEnv;
    }

    /**
     * Method to a view resolver.
     *
     * @return bean
     */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean =
                new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("./WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    /**
     * Method to set a data of source.
     *
     * @return a data of source
     */
    @Bean
    public DataSource ds() {
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(this.env.getProperty("jdbc.driver"));
        ds.setUrl(this.env.getProperty("jdbc.url"));
        ds.setUsername(this.env.getProperty("jdbc.username"));
        ds.setPassword(this.env.getProperty("jdbc.password"));
        return ds;
    }

    /**
     * Method to set jdbc template.
     *
     * @return jdbc template
     **/
    @Bean
    public JdbcTemplate jdbc() {
        final JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(ds());
        return template;
    }
}
