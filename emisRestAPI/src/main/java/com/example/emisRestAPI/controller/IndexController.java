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
import java.util.List;

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

        httpHeaders.put("Content-Type", Collections.singletonList("application/json"));
        httpHeaders.put("X-Ekonerg-Login", Collections.singletonList("test"));
        httpHeaders.put("X-Ekonerg-MAC", Collections.singletonList("0zsztndLpk9XxuQetmo9uGWTnNtFu7xHjiWPUQ26iFA="));
        httpHeaders.put("Content-Length", Collections.singletonList(String.valueOf(string.length())));
        httpHeaders.put("Host", Collections.singletonList("https://www.isge.hr/em-remote-service"));

        HttpEntity<String> entity = new HttpEntity<String>(string, httpHeaders);

        return restTemplate.exchange("https://www.isge.hr/em-remote-service/batch/json/echo", HttpMethod.POST, entity, String.class).getBody();
    }
}
