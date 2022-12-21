package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService{
    private final BudgetRepository budgetRepo;
    public BudgetService(BudgetRepository budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public Budget getBudgetById(Long id) {
        return budgetRepo.findBudgetById(id).orElse(null);
    }
    public Iterable<Budget> getAllBudgets(){
        return budgetRepo.findAll();
    }
    public void addBudget(Budget budget) {
        budgetRepo.save(budget);
    }

    public void updateBudgetBalance(Long id, Long balance) throws Exception {
        final var budget = budgetRepo.findBudgetById(id).orElse(null);
        if(budget == null)
            throw new Exception();
        budget.balance = balance;
        budgetRepo.save(budget);
    }
}
