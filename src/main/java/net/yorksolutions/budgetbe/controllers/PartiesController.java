package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Party;
import net.yorksolutions.budgetbe.services.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/parties")
@CrossOrigin
public class PartiesController {
    private final PartyService service;
    public PartiesController(PartyService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Party getParties(@PathVariable Long id){
            return service.getPartyById(id);
    }
    @GetMapping
    public Iterable<Party> getParties(){
            return service.getAllParties();
    }

    @PostMapping
    public void addParty(@RequestBody Party party) {
        try {
            service.addParty(party);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }
}
