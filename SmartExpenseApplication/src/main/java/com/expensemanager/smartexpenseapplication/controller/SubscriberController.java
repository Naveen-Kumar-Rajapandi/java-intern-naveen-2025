package com.expensemanager.smartexpenseapplication.controller;

import com.expensemanager.smartexpenseapplication.dto.UserSubscriberDTO;
import com.expensemanager.smartexpenseapplication.entity.Subscriber;
import com.expensemanager.smartexpenseapplication.service.SubscriberService;
import com.expensemanager.smartexpenseapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriber")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<List<UserSubscriberDTO>> addSubscriber(@RequestBody Subscriber subscriber)
    {
        return subscriberService.addSubscriber(subscriber);
    }
}
