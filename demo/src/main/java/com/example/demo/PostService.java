package com.example.demo;

import com.example.demo.Factory;
import com.example.demo.Model;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class PostService {

//    url : https://jsonplaceholder.typicode.com/posts
    private static final String URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Model> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        Model[] models = restTemplate.getForObject(URL, Model[].class);
        assert models != null;
        return List.of(models);
    }

}
