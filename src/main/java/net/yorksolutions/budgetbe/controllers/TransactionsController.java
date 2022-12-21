package net.yorksolutions.budgetbe.controllers;

import net.yorksolutions.budgetbe.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {
    private Long newTransactionId = 0L;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    @GetMapping
    public Iterable<Transaction> getTransactionById(
            @RequestParam(required = false) Long id){
        if(id == null)
            return transactions;
        else
            for (Transaction transaction : transactions){
                if(transaction.id.equals(id)){
                    return List.of(new Transaction[]{transaction});
                }
            }
        return List.of(new Transaction[]{});
    }

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction){
        transaction.id = newTransactionId++;
        transactions.add(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTransactionBudgetId(
            @PathVariable Long id,
            @RequestBody Long budgetId){

        System.out.println("updating transaction");

        for(Transaction existingTransaction : transactions){
            if(id.equals(existingTransaction.id)){
                int set = transactions.indexOf(existingTransaction);
                existingTransaction.budgetId = budgetId;
                transactions.set(set, existingTransaction);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
