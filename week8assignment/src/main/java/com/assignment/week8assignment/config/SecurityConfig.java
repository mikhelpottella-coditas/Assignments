package com.assignment.week8assignment.config;

import com.assignment.week8assignment.controller.TaskController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder().username("admin").password(bCryptPasswordEncoder().encode("1234")).roles("ADMIN").build();
        UserDetails manager = User.builder().username("manager").password(bCryptPasswordEncoder().encode("1234")).roles("MANAGER").build();
        return new InMemoryUserDetailsManager(admin,manager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/tasks/**").authenticated()
                        .anyRequest()
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return security.build();

    }



}
