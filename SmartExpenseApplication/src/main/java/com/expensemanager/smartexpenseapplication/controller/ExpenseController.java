package com.expensemanager.smartexpenseapplication.controller;

import com.expensemanager.smartexpenseapplication.entity.Expense;
import com.expensemanager.smartexpenseapplication.entity.RangeType;
import com.expensemanager.smartexpenseapplication.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<Expense> viewExpenseList()
    {
        return expenseService.viewExpenseList();
    }

    @PostMapping("/filter/belowthelimit")
    public List<Expense> filterExpenseBelowTheLimit(@Valid @RequestBody double price)
    {
        return expenseService.filterExpenseBelowTheLimit(price);
    }
    @PostMapping("/filter/abovethelimit")
    public List<Expense> filterExpenseAboveTheLimit(@Valid @RequestBody double price)
    {
        return expenseService.filterExpenseAboveTheLimit(price);
    }

    @PostMapping("/filter/betweentherange")
    public List<Expense> filterExpenseBetweenTheRange(@RequestBody RangeType range)
    {
        return expenseService.filterExpenseBetweenTheRange(range);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> removeExpense(@RequestParam String removeExp)
    {
        return expenseService.removeExpense(removeExp);
    }
}
