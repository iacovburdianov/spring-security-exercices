package com.example.demo.config.security.providers;

import com.example.demo.config.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 5/7/2023
 *
 * @author : Admin
 * @date : 5/7/2023
 * @project : ss_2023_c3_e1
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${our.very.very.very.secret.key}")
    private String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication ca = (CustomAuthentication) authentication;
        String headerKey = ca.getKey();

        if (key.equals(headerKey)) {
            return new CustomAuthentication(true, null);
        }
        throw new BadCredentialsException("OH No!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
