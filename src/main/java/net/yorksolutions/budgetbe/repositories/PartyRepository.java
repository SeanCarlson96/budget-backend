package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends CrudRepository {

    public Party findPartyById(Long id);
    public Iterable<Party> findAll();
}
