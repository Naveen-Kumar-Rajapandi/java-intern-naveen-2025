package com.expensemanager.smartexpenseapplication.service;

import com.expensemanager.smartexpenseapplication.entity.Expense;
import com.expensemanager.smartexpenseapplication.entity.RangeType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService
{
    Map<String,Double> expenseList = new HashMap<>();
    public ResponseEntity<String> addExpense(Expense expense)
    {
        if(expenseList.containsKey(expense.getCategory()))
        {
            expenseList.compute(expense.getCategory(),(key,oldValue) -> oldValue + expense.getExpense());
            return ResponseEntity.ok("EXPENSE UPDATED IN EXIST CATEGORY !!!");
        }
        else
        {
            expenseList.put(expense.getCategory(), expense.getExpense());
            return ResponseEntity.ok("EXPENSE ADDED SUCCESSFULLY !!!");
        }
    }

    public Map<String,Double> viewExpenseList()
    {
        return expenseList;
    }

    public Map<String,Double> filterExpenseBelowTheLimit(double price)
    {
        return expenseList.entrySet().stream()
                .filter(p -> p.getValue() < price)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
    public Map<String,Double> filterExpenseAboveTheLimit(double price)
    {
        return expenseList.entrySet().stream()
                .filter(p -> p.getValue() >= price)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    public Map<String,Double> filterExpenseBetweenTheRange(RangeType range)
    {
        return expenseList.entrySet().stream()
                .filter(p -> p.getValue() >= range.initialPrice() && p.getValue() <= range.finalPrice())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    public ResponseEntity<String> removeExpense(String removeExp)
    {
        System.out.println(removeExp);
        if(expenseList.containsKey(removeExp)) {
            expenseList.remove(removeExp);
            return ResponseEntity.ok("EXPENSE REMOVED FROM THE LIST");
        }
        return ResponseEntity.ok("NOT FOUND !!");
    }
}
