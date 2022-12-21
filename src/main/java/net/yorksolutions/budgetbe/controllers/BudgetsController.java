package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.services.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/budgets")
@CrossOrigin
public class BudgetsController {
    private final BudgetService service;
    public BudgetsController(BudgetService service) {
        this.service = service;
    }
    @GetMapping(params={"id"})
    public Budget getBudgetById(@RequestParam Long id){
        return service.getBudgetById(id);
    }
    @GetMapping
    public Iterable<Budget> getBudgets(){
        return service.getAllBudgets();
    }

    @PostMapping
    public void addBudget(@RequestBody Budget budget){
        try {
            service.addBudget(budget);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PatchMapping//("/{id}")
    public void updateBudgetBalance(
            @RequestParam Long id,
            @RequestBody Long balance){
        try {
            service.updateBudgetBalance(id, balance);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
