package com.samsung.samsungProjectServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable().authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/user").permitAll()
                .requestMatchers(HttpMethod.GET, "/user").permitAll()
                .requestMatchers(HttpMethod.GET,"user/leaderboard").permitAll()
                .requestMatchers(HttpMethod.PATCH, "user/{id}/score").permitAll()
                .requestMatchers(HttpMethod.POST, "/shape").permitAll()
                .requestMatchers(HttpMethod.POST, "/shape/all").permitAll()
                .requestMatchers(HttpMethod.GET, "/shape/all").permitAll()
                .requestMatchers(HttpMethod.GET, "shape/recent").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic(Customizer.withDefaults()).build();

    }

}
