package com.ilyap.yuta.models;

import java.io.Serializable;

public class Faculty implements Serializable {
    private int id;
    private String name;

    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}