package com.pfe.hostelmangement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
        return httpSecurity
          .formLogin(Customizer.withDefaults())
          .authorizeHttpRequests(ar->ar.requestMatchers("/test/**").hasRole("ADMIN"))
          .authorizeHttpRequests(ar->ar.requestMatchers("/web/**").permitAll())
          .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
          .build();
  }
}