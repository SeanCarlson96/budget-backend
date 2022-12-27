package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.BudgetId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetIdRepository extends CrudRepository<BudgetId, Long> {

}
