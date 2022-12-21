package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/budgets")
@CrossOrigin
public class BudgetsController {
    private Long newBudgetId = 0L;
    private ArrayList<Budget> budgets = new ArrayList<>();

    @GetMapping(params={"id"})
    public Budget getBudgetById(@RequestParam Long id){
            for(Budget budget : budgets){
                if(budget.id.equals(id)){
                    return budget;
                }
            }
        return null;
    }
    @GetMapping
    public Iterable<Budget> getBudgets(){
            return budgets;
    }

    @PostMapping
    public ResponseEntity<Void> addBudget(@RequestBody Budget budget){
        //check if the budget name already exists
        for (Budget existingBudget : budgets){
            if(budget.name.equals(existingBudget.name)){
                return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
            }
        }
        budget.id = newBudgetId++;
        budgets.add(budget);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping//("/{id}")
    public ResponseEntity<Void> updateBudgetBalance(
            @RequestParam Long id,
            @RequestBody Map balance){
        for(Budget existingBudget : budgets){
            if(id.equals(existingBudget.id)){
                int set = budgets.indexOf(existingBudget);
                existingBudget.balance = (((Integer) balance.get("balance")).longValue());
                budgets.set(set, existingBudget);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
