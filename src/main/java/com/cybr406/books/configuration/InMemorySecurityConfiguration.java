package com.cybr406.books.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Profile("!jdbc")
public class InMemorySecurityConfiguration extends SharedSecurityConfiguration {
  
  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    User.UserBuilder builder = User.withDefaultPasswordEncoder();

    InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
    
    userDetailsManager.createUser(builder
        .username("admin")
        .password("admin")
        .roles("ADMIN")
        .build());
    
    userDetailsManager.createUser(builder
        .username("frankh")
        .password("password")
        .roles("AUTHOR")
        .build());

    userDetailsManager.createUser(builder
        .username("philipkd")
        .password("password")
        .roles("AUTHOR")
        .build());

    return userDetailsManager;
  }
  
}
