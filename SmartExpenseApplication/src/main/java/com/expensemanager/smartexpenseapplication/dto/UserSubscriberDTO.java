package com.expensemanager.smartexpenseapplication.dto;

import com.expensemanager.smartexpenseapplication.entity.Subscriber;
import com.expensemanager.smartexpenseapplication.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSubscriberDTO {

    private User user;
    private Subscriber subscriber;
}
