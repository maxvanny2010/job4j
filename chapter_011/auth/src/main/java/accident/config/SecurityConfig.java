package accident.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * SecurityConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/10/2020
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * field a source for db.
     */
    private final DataSource ds;

    /**
     * Constructor.
     *
     * @param ds source for db
     */
    public SecurityConfig(final DataSource ds) {
        this.ds = ds;
    }

    @Override
    protected final void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        auth.jdbcAuthentication()
                .dataSource(this.ds)
                .withUser(User.withUsername("user")
                        .password(passwordEncoder.encode("123456"))
                        .roles("USER"));
    }

    /**
     * Method to get.
     *
     * @return encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/**")
                .hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/sd")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .and()
                .csrf()
                .disable();
    }
}
