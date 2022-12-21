package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository {

    public Optional<Transaction> findTransactionById(Long id);
    public Iterable<Transaction> findAll();
}
