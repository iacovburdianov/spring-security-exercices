package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by Admin on 5/8/2023
 *
 * @author : Admin
 * @date : 5/8/2023
 * @project : ss_2023_c6_e1
 */
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .authorities("read") //--> GrantedAuthority interface
                .build();
        var u2 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .authorities("write", "delete")
                .build();
        uds.createUser(u1);
        uds.createUser(u2);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/demo/**").hasAuthority("read")
                .requestMatchers(HttpMethod.POST, "/demo/demo3").hasAuthority("write")
                .anyRequest().authenticated()
                .and().csrf().disable() // dont do this in real-world apps
                .build();
    }
}
