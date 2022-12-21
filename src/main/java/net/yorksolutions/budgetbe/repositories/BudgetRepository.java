package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.models.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    Optional<Budget> findBudgetById(Long id);
    public Iterable<Budget> findAll();
}
