package com.pfe.hostelmangement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
            User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("user")
                    .roles("USER")
                    .build();

    return new InMemoryUserDetailsManager(user);
  }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(ar->ar.requestMatchers("/test/**").hasRole("ADMIN"))
            .authorizeHttpRequests(ar->ar.requestMatchers("/web/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/booking/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/hotel/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/activity/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/hotel").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/restaurant/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/login").permitAll())
            .authorizeHttpRequests(ar->ar.anyRequest().authenticated())

            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("*"));
                configuration.setAllowedMethods(Arrays.asList("*"));
                configuration.setAllowedHeaders(Arrays.asList("*"));
                return configuration;
            }))

            .csrf(csrf -> csrf.disable()) // Disable CSRF using the new lambda-based configuration
            .build();
    }

}