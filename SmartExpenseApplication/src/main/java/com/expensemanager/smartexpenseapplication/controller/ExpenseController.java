package com.expensemanager.smartexpenseapplication.controller;

import com.expensemanager.smartexpenseapplication.entity.Expense;
import com.expensemanager.smartexpenseapplication.entity.RangeType;
import com.expensemanager.smartexpenseapplication.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController
{
    @Autowired
    ExpenseService expenseService;
    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense)
    {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/view")
    public Map<String,Double> viewExpenseList()
    {
        return expenseService.viewExpenseList();
    }

    @PostMapping("/filter/belowthelimit")
    public Map<String,Double> filterExpenseBelowTheLimit(@RequestBody double price)
    {
        return expenseService.filterExpenseBelowTheLimit(price);
    }
    @PostMapping("/filter/abovethelimit")
    public Map<String,Double> filterExpenseAboveTheLimit(@RequestBody double price)
    {
        return expenseService.filterExpenseAboveTheLimit(price);
    }

    @PostMapping("/filter/betweentherange")
    public Map<String,Double> filterExpenseBetweenTheRange(@RequestBody RangeType range)
    {
        return expenseService.filterExpenseBetweenTheRange(range);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> removeExpense(@RequestParam String removeExp)
    {
        return expenseService.removeExpense(removeExp);
    }
}
