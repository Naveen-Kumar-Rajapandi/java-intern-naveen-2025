package com.expensemanager.smartexpenseapplication.controller;

import com.expensemanager.smartexpenseapplication.entity.User;
import com.expensemanager.smartexpenseapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/user")
public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/view")
    public Collection<User> viewAllUsers() {
        return userService.viewAllUsers();
    }

    @GetMapping("get/{mobile}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable Long mobile) {
        User user = userService.getUserByPhoneNumber(mobile);
        if( user != null )
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }
}
