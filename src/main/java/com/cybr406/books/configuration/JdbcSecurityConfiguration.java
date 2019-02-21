package com.cybr406.books.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@Profile("jdbc")
public class JdbcSecurityConfiguration extends SharedSecurityConfiguration {

  @Autowired
  DataSource dataSource;

  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
  
  @Bean
  JdbcUserDetailsManager jdbcUserDetailsManager() {
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  User.UserBuilder userBuilder() {
    PasswordEncoder passwordEncoder = passwordEncoder();
    User.UserBuilder users = User.builder();
    users.passwordEncoder(passwordEncoder::encode);
    return users;
  }
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder passwordEncoder = passwordEncoder();
    
    User.UserBuilder users = User.builder();
    users.passwordEncoder(passwordEncoder::encode);
    
    auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .withDefaultSchema()
        .withUser(users
            .username("admin")
            .password("admin")
            .roles("ADMIN"))
        .withUser(users
            .username("frankh")
            .password("password")
            .roles("AUTHOR"))
        .withUser(users
            .username("philipkd")
            .password("password")
            .roles("AUTHOR"));
  }



  
}
