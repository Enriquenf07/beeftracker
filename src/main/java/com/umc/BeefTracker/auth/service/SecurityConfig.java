package com.umc.BeefTracker.auth.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 1. Libera o que é público (CSS, JS e a própria página de login)
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        // 3. Qualquer outra rota também exige login (opcional, dependendo do seu projeto)
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define qual é a página de login
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                        .permitAll()         // Garante que todos acessem a tela de login
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Após deslogar, volta para o login
                        .permitAll()
                );

        return http.build();
    }
}
