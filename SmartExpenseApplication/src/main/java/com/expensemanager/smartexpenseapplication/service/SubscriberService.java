package com.expensemanager.smartexpenseapplication.service;

import com.expensemanager.smartexpenseapplication.dto.UserSubscriberDTO;
import com.expensemanager.smartexpenseapplication.entity.Subscriber;
import com.expensemanager.smartexpenseapplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriberService {

    @Autowired
    UserService userService;

    Map<User,Subscriber> subscribersList = new HashMap<>();
    List<UserSubscriberDTO> dtoList = new ArrayList<>();
    public ResponseEntity<List<UserSubscriberDTO>> addSubscriber(Subscriber subscriber)
    {
            User s = userService.getUser(subscriber.getMobile());
            if(s == null)
            {
                return ResponseEntity.notFound().build();
            }
            subscribersList.put(s,subscriber);
            dtoList = subscribersList.entrySet()
                    .stream()
                    .map(entry -> new UserSubscriberDTO(
                            entry.getKey(),
                            entry.getValue()
                    ))
                    .toList();

            return ResponseEntity.ok(dtoList);
    }
}
