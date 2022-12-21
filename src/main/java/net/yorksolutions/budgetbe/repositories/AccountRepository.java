package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    public Optional<Account> findAccountById(Long id);
    public Iterable<Account> findAll();
}
