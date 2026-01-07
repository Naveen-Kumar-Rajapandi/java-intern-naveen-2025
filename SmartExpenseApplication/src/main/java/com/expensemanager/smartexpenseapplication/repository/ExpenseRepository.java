package com.expensemanager.smartexpenseapplication.repository;

import com.expensemanager.smartexpenseapplication.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByExpenseLessThan(Double price);
    List<Expense> findByExpenseGreaterThan(Double price);
    List<Expense> findByExpenseBetween(Double start,Double end);
    void deleteByExpense(String removeExp);
}
