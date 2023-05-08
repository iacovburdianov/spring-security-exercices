package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 5/8/2023
 *
 * @author : Admin
 * @date : 5/8/2023
 * @project : ss_2023_c5_e1
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "Demo";
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
