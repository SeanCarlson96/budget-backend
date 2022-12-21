package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.models.Party;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountsController {
    private Long newAccountId = 0L;
    private ArrayList<Account> accounts = new ArrayList<>();

    @GetMapping(params={"id"})
    public Account getAccountById(@RequestParam Long id){
            for (Account account : accounts) {
                if (account.id.equals(id)) {
                    return account;
                }
            }
            return null;
    }
    @GetMapping
    public Iterable<Account> getAccounts(){
            return accounts;
    }

    @PostMapping
    public ResponseEntity<Void> addAccount(@RequestBody Account account){
        //check if the account name already exists
        for (Account existingAccount : accounts){
            if(account.name.equals(existingAccount.name)){
                return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
            }
        }
        account.id = newAccountId++;
        accounts.add(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping//("/{id}")
    public ResponseEntity<Void> updateAccountBalance(
            @RequestParam Long id,
            @RequestBody Map balance){
        for(Account existingAccount : accounts){
            if(id.equals(existingAccount.id)){
                int set = accounts.indexOf(existingAccount);
                existingAccount.balance = (((Integer) balance.get("balance")).longValue());
                accounts.set(set, existingAccount);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
