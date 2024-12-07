package com.harkka.harkkatyo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (use cautiously in production)
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // Allow H2 Console frames
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 Console
                        .requestMatchers("/accounts/**").permitAll() // Allow access to /accounts
                        .anyRequest().authenticated() // Require authentication for all other paths
                )
                .formLogin(form -> form.permitAll()) // Enable login
                .logout(logout -> logout.permitAll()); // Enable logout

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
