package accident.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
     * @param aDs source for db
     */
    public SecurityConfig(final DataSource aDs) {
        this.ds = aDs;
    }

    @Override
    protected final void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        auth.jdbcAuthentication()
                .dataSource(this.ds)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                //.passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select username,password, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select u.username, r.roles"
                        + " from users u inner join user_role r"
                        + " on u.id_users = r.users_id"
                        + " where username=?");
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
                .antMatchers("/list").hasAnyAuthority("USER")
                .antMatchers("/login", "/registration", "/reg")
                .permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/list")
                .failureUrl("/login?error=true")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }

    @Override
    public final void configure(final WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**");
    }
}
