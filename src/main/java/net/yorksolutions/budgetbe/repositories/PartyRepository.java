package net.yorksolutions.budgetbe.repositories;

import net.yorksolutions.budgetbe.models.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends CrudRepository<Party, Long> {

    public Optional<Party> findPartyById(Long id);
    public Iterable<Party> findAll();
}
