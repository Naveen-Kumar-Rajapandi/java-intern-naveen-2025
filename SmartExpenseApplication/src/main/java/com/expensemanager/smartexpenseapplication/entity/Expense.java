package com.expensemanager.smartexpenseapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense {
    private String category;
    private double expense;
}
