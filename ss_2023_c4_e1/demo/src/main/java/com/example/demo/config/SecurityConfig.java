package com.example.demo.config;


import com.example.demo.config.filters.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by Admin on 5/7/2023
 *
 * @author : Admin
 * @date : 5/7/2023
 * @project : ss_2023_c4_e1
 */
@Configuration
public class SecurityConfig {

    @Value("${the.secret}")
    private String key;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
                .and()
                .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .build();
    }
}
