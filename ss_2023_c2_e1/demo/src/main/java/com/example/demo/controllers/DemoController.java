package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 5/5/2023
 *
 * @author : Admin
 * @date : 5/5/2023
 * @project : ss_2023_c2_e1
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "Demo";
    }
}
