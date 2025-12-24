package com.expensemanager.smartexpenseapplication.service;


import com.expensemanager.smartexpenseapplication.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService {

    HashMap<Long, User> userList = new HashMap<>();


    public ResponseEntity<String> addUser(Long mobile, User user)
    {
        if (userList.containsKey(mobile) == false)
        {
            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();
            user.setId(id);
            userList.put(mobile, user);
        }
        else
            return ResponseEntity.ok("DUPLICATE USERS NOT ALLOWED !");
        return ResponseEntity.ok("USER ADDED SUCCESSFULLY !");
    }


    public Collection<User> viewAllUsers() {
        Collection<User> temp = userList.values();
        return temp;
    }

    public User getUserByPhoneNumber(Long mobile)
    {
        /*if(userList.containsKey(mobile))
            return (userList.get(mobile).getId()+"\n"+userList.get(mobile).getName()).toString();
        else
            return "MATCH NOT FOUND !!";*/
        System.out.println(userList.get(mobile));
        return userList.get(mobile);
    }

    public User getUser(Long mobile)
    {
        if(userList.containsKey(mobile))
            return userList.get(mobile);
        else
            return null;
    }
}
