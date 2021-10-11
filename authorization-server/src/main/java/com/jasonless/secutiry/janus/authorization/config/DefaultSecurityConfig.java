package com.jasonless.secutiry.janus.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author
 * @date 2021/9/29
 */
@EnableWebSecurity
public class DefaultSecurityConfig {

    @Bean
    UserDetailsService users(){
        UserDetails user = User.builder().username("jasonless").password("{noop}123456")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .formLogin(withDefaults());
        return httpSecurity.build();
    }

}
