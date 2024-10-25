package com.example.demo;

import com.example.demo.Model;

public class Factory {
    public static Model createModel(int id, String title) {
        Model model = new Model(id, title);
        model.setId(id);
        model.setTitle(title);
        return model;
    }
}
