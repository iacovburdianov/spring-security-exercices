package com.example.demo.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 5/12/2023
 *
 * @author : Admin
 * @date : 5/12/2023
 * @project : ss_2023_c8_e2
 */
@Component
public class Demo4ConditionEvaluator {
    public boolean condition() {
        var a = SecurityContextHolder.getContext().getAuthentication();
        return true; // my complex authorization condition
                        // instead of write these condition above the method with SpEL
    }
}
