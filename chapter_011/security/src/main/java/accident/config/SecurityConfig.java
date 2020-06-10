package accident.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
 /*   private final PasswordEncoder passwordEncoder;

    public SecurityConfig(final PasswordEncoder aPasswordEncoder) {
        this.passwordEncoder = aPasswordEncoder;
    }*/
//добавил вот этот метод
    @Autowired
    public void configureGlobalSecurity(final AuthenticationManagerBuilder auth) throws Exception {
        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user")
                .password(passwordEncoder.encode("123"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "ADMIN");
    }
  /*  @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(this.passwordEncoder)
                .withUser("user")
                .password(this.passwordEncoder.encode("123"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(this.passwordEncoder.encode("123"))
                .roles("USER", "ADMIN");
    }*/

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
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
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
