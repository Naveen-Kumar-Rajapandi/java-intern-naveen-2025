package com.expensemanager.smartexpenseapplication.service;


import com.expensemanager.smartexpenseapplication.entity.User;
import com.expensemanager.smartexpenseapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> addUser(User user)
    {
        if (userRepository.findByMobile(user.getMobile()) != null )
        {
            return ResponseEntity.ok("DUPLICATE USERS NOT ALLOWED !");
        }
        userRepository.save(user);
        return ResponseEntity.ok("USER ADDED SUCCESSFULLY !");
    }


    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByPhoneNumber(Long mobile)
    {
        /*
        if(userList.containsKey(mobile))

            return (userList.get(mobile).getId()+"\n"+userList.get(mobile).getName()).toString();
        else
            return "MATCH NOT FOUND !!";
        System.out.println(userList.get(mobile));
        return userList.get(mobile);
        */
         return userRepository.findByMobile(mobile);
    }

}
