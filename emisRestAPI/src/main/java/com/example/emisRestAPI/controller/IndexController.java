package com.example.emisRestAPI.controller;

import com.example.emisRestAPI.model.IndexModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public IndexModel index(){
        return new IndexModel("response");
    }


}
