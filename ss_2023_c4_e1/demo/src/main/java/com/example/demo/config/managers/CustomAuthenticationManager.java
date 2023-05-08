package com.example.demo.config.managers;

import com.example.demo.config.providers.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
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
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider = new ApiKeyProvider(key);
        if (provider.supports(authentication.getClass())) {
           return provider.authenticate(authentication);
        }

        return authentication;
    }
}
