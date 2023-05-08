package com.example.demo.config.providers;

import com.example.demo.config.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by Admin on 5/8/2023
 *
 * @author : Admin
 * @date : 5/8/2023
 * @project : ss_2023_c4_e1
 */
@AllArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {
    private final String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication auth = (ApiKeyAuthentication)authentication;
        if (key.equals(auth.getKey())){
            auth.setAuthenticated(true);
            return auth;
        }
        throw new BadCredentialsException(":(");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
