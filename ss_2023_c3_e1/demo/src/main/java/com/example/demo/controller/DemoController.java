package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Iacov Burdianov on 5/7/2023
 *
 * @author : Iacov Burdianov
 * @date : 5/7/2023
 * @project : ss_2023_c3_e1
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "Demo Iacov";
    }
}
