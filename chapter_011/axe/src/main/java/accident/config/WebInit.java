package accident.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
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
        ac.register(AppConfig.class);
        ac.refresh();
        final CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        final FilterRegistration.Dynamic encoding = servletCxt.addFilter(
                "encoding", filter);
        encoding.addMappingForUrlPatterns(
                null, false, "/*");
        final DispatcherServlet servlet = new DispatcherServlet(ac);
        final ServletRegistration.Dynamic registration =
                servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        final long maxFileSize = 20_971_520L;
        final long maxRequestSize = 41_943_040L;
        final int fileSizeThreshold = 512_000;
        registration.setMultipartConfig(new MultipartConfigElement(
                null, maxFileSize, maxRequestSize, fileSizeThreshold));
        registration.setAsyncSupported(true);
        registration.addMapping("/axe");
        registration.addMapping("/save");
        registration.addMapping("/create");
        registration.addMapping("/edit");
        registration.addMapping("/update");
    }
}
