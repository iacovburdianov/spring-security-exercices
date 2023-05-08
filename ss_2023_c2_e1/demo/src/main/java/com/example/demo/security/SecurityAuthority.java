package com.example.demo.security;

import com.example.demo.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Admin on 5/6/2023
 *
 * @author : Admin
 * @date : 5/6/2023
 * @project : ss_2023_c2_e1
 */
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
