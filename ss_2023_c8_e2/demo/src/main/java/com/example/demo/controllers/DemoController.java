package com.example.demo.controllers;

import com.example.demo.security.Demo4ConditionEvaluator;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 5/9/2023
 *
 * @author : Admin
 * @date : 5/9/2023
 * @project : ss_2023_c7_e1
 */
@RestController
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('read')")
    public String demo1() {
        return "Demo 1";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAnyAuthority('write', 'read')")
    public String demo2() {
        return "Demo 2";
    }


    @GetMapping("/demo3/{smth}")
    @PreAuthorize("#something == authentication.name")// authentication from SecurityContext
    public String demo3(@PathVariable("smth")String something) {
        var a = SecurityContextHolder.getContext().getAuthentication();
        return "Demo 3";
    }

    @GetMapping("/demo4/{smth}")
    @PreAuthorize("@demo4ConditionEvaluator.condition")
    public String demo4() {
        return "Demo 4";
    }



}
