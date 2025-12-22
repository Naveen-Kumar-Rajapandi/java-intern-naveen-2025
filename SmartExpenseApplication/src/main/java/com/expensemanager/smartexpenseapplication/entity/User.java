package com.expensemanager.smartexpenseapplication.entity;

import lombok.*;

@Data
public class User {
    private String id;
    private String name;
    private String company;
    private long mobile;
    public User() {
    }
    public User(String id,String name,long mobile)
    {
        this.id=id;
        this.name=name;
        company="KOVAN LABS";
        this.mobile=mobile;
    }
}
