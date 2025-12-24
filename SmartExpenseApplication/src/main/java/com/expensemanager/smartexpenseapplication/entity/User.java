package com.expensemanager.smartexpenseapplication.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class User {


    private String id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    private String company;
    @NotBlank(message = "mobile number is mandatory")
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
