package com.example.emisRestAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {


    @GetMapping("/test")
    public String test(){
        return new String("Test");
    }

}
