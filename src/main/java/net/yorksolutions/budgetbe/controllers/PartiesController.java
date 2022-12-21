package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Budget;
import net.yorksolutions.budgetbe.models.Party;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parties")
@CrossOrigin
public class PartiesController {
    private Long newPartyId = 0L;
    private ArrayList<Party> parties = new ArrayList<>();

    @GetMapping(params={"id"})
    public Party getParties(@RequestParam Long id){
            for(Party party : parties){
                if(id.equals(party.id)){
                    return party;
                }
            }
            return null;
    }
    @GetMapping
    public Iterable<Party> getParties(){
            return parties;
    }

    @PostMapping
    public ResponseEntity<Void> addParty(@RequestBody Party party){
        //check if the party name already exists
        for (Party existingParty : parties){
            if(party.name.equals(existingParty.name)){
                return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
            }
        }
        party.id = newPartyId++;
        parties.add(party);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
