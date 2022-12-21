package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Party;
import net.yorksolutions.budgetbe.repositories.PartyRepository;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    private final PartyRepository partyRepo;
    public PartyService(PartyRepository partyRepo) {
        this.partyRepo = partyRepo;
    }
    public Party getPartyById(Long id){
        return partyRepo.findPartyById(id);
    }

    public Iterable<Party> getAllParties() {
        return partyRepo.findAll();
    }
    public void addParty(Party party) {
        partyRepo.save(party);
    }
}
