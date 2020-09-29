package com.gole.SpringSecuritydemo.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        /*
        * NORMAL USERS STUDENT
        * */
    UserDetails sandipStudent=User.builder()
                .username("gole")
                .password(passwordEncoder.encode("password"))
                .roles("STUDENT")
            .build();

    /*
    * ADMIN USER
    * */

        UserDetails admin=User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(
                sandipStudent,
                admin
        );
    }
}
