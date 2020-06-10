package accident.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * WebInit.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public class WebInit implements WebApplicationInitializer {
    @Override
    public final void onStartup(final ServletContext servletCxt) {
        final AnnotationConfigWebApplicationContext ac =
                new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class, DataConfig.class);
        ac.refresh();
        final DispatcherServlet servlet = new DispatcherServlet(ac);
        final ServletRegistration.Dynamic registration =
                servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/sd");
    }
}
