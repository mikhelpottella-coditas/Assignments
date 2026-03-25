package com.evaluation.week6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails michael = User.builder()
                .username("michael")
                .password("{noop}12345")
                .roles("USER")
                .build();


        UserDetails swaraj = User.builder()
                .username("swaraj")
                .password("{noop}12345")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(michael, swaraj);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/emp/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/emp/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/emp/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/emp/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/emp/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}