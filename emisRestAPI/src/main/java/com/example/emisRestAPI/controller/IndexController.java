package com.example.emisRestAPI.controller;

import com.example.emisRestAPI.model.IndexModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public IndexModel[] index(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);


        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, IndexModel[].class).getBody();
    }

    @PostMapping("/")
    public String indexPost(@RequestBody IndexModel indexModel){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<IndexModel> entity = new HttpEntity<IndexModel>(indexModel, httpHeaders);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, entity, String.class).getBody();
    }
}
