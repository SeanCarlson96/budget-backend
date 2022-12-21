package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountsController {
    private final AccountService service;
    public AccountsController(AccountService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return service.getAccountById(id);
    }
    @GetMapping
    public Iterable<Account> getAccounts(){
        return service.getAllAccounts();
    }
    @PostMapping
    public void addAccount(@RequestBody Account account){
        try {
            service.addAccount(account);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }
    @PatchMapping("/{id}")
    public void updateAccountBalance(
            @PathVariable Long id,
            @RequestBody Long balance){
        try {
            service.updateAccountBalance(id, balance);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
