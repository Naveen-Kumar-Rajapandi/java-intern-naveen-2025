package com.expensemanager.smartexpenseapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subscriber
{
    private long mobile;
    private Plan plan;
    private Status status;

    public enum Plan{
        GOLD,
        SILVER
    }
    public enum Status{
        ACTIVE,
        INACTIVE,
        SUSPEND
    }

}
