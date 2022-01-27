package com.example.emisRestAPI.controller;

import com.example.emisRestAPI.helper.IndexControllerHelper;
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
public class IndexController extends IndexControllerHelper {

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
    public String indexPost(@RequestBody String string){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String encodedHeader = headerEncoding(string);

        HttpEntity<String> entity = new HttpEntity<String>(encodedHeader, httpHeaders);

        return restTemplate.exchange("https://www.isge.hr/em-remote-service/batch/json/echo", HttpMethod.POST, entity, String.class).getBody();
    }
}
