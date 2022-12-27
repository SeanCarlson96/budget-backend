package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Transaction;
import net.yorksolutions.budgetbe.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {
    private final TransactionService service;
    public TransactionsController(TransactionService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id){
        return service.getTransactionById(id);
    }
    @GetMapping
    public Iterable<Transaction> getAllTransactions(){
        return service.getAllTransactions();
    }

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction){
        service.addTransaction(transaction);
    }

    @PatchMapping("/{id}")
    public void updateTransactionBudgetId(
            @PathVariable Long id,
            @RequestBody Long budgetId){
        try {
            service.updateTransactionBudgetId(id, budgetId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionById(@PathVariable Long id){
        try {
            service.deleteTransactionById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
