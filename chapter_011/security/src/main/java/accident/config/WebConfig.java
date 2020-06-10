package accident.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * WebConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Configuration
@ComponentScan("accident")
@Import({SecurityConfig.class})
public class WebConfig {
//здесь добавил импорт без него не запускалось
    /**
     * Constructor.
     */
    public WebConfig() {
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
}
