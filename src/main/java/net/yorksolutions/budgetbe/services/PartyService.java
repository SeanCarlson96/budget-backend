package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.BudgetId;
import net.yorksolutions.budgetbe.models.Party;
import net.yorksolutions.budgetbe.models.PartyRequestBody;
import net.yorksolutions.budgetbe.repositories.BudgetIdRepository;
import net.yorksolutions.budgetbe.repositories.PartyRepository;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    private final PartyRepository partyRepo;
    private final BudgetIdRepository budgetIdRepo;
    public PartyService(PartyRepository partyRepo, BudgetIdRepository budgetIdRepo) {
        this.partyRepo = partyRepo;
        this.budgetIdRepo = budgetIdRepo;
    }
    public Party getPartyById(Long id){
        return partyRepo.findPartyById(id).orElse(null);
    }

    public Iterable<Party> getAllParties() {
        return partyRepo.findAll();
    }
    public void addParty(PartyRequestBody party) {
        BudgetId budgetId = new BudgetId();
        budgetId.budgetId = party.budgetId;
        budgetIdRepo.save(budgetId);

        party.party.budgetIdList.add(budgetId);
        partyRepo.save(party.party);
    }
}
