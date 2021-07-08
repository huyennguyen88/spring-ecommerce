package com.example.springecommerce.config;

import com.example.springecommerce.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // No need login
        http.authorizeRequests().antMatchers("/welcome", "/login-page", "/logout").permitAll();

        //Need login
        http.authorizeRequests().antMatchers("/users/**","orders/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        //Wrong user access
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access-denied");

        //Login form config
        http.authorizeRequests().and().formLogin()
                // Submit URL login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login-page")
                .defaultSuccessUrl("/login-success",false)
                .failureUrl("/login-page?error")
                .usernameParameter("username")
                .passwordParameter("password")
                // Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login-page?logout");

    }

}
