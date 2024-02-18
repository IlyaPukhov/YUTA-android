package com.ilyap.yuta.models;

import java.util.List;

import lombok.Value;

@Value
public class Team {
    int id;
    String name;
    User leader;
    List<User> members;
}