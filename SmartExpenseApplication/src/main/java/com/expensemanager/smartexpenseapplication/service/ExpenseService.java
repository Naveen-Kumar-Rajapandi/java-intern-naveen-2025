package com.expensemanager.smartexpenseapplication.service;

import com.expensemanager.smartexpenseapplication.entity.Expense;
import com.expensemanager.smartexpenseapplication.entity.*;
import com.expensemanager.smartexpenseapplication.entity.RangeType;
import com.expensemanager.smartexpenseapplication.repository.ExpenseRepository;
import com.expensemanager.smartexpenseapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService
{
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    UserRepository userRepository;


    public ResponseEntity<String> addExpense (Expense expense)
    {
        User user = userRepository.findByMobile(expense.getUser().getMobile());
        expenseRepository.save(expense);
        return ResponseEntity.ok("EXPENSE ADDED SUCCESSFULLY !!");
    }

    public List<Expense> viewExpenseList()
    {
        return expenseRepository.findAll();
    }

    public List<Expense> filterExpenseBelowTheLimit(Double price)
    {
        return expenseRepository.findByExpenseLessThan(price);
    }
    public List<Expense> filterExpenseAboveTheLimit(Double price)
    {
        return expenseRepository.findByExpenseGreaterThan(price);
    }

    public List<Expense> filterExpenseBetweenTheRange(RangeType range)
    {
        return expenseRepository.findByExpenseBetween(range.initialPrice(), range.finalPrice());
    }

    public ResponseEntity<String> removeExpense(String removeExp)
    {
        expenseRepository.deleteByExpense(removeExp);
        return ResponseEntity.ok("EXPENSE DELETED SUCCESSFULLY !");
    }
}
