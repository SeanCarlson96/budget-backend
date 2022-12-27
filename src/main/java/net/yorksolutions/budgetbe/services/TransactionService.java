package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Transaction;
import net.yorksolutions.budgetbe.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepo;
    public TransactionService(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Transaction getTransactionById(Long id){
        return transactionRepo.findTransactionById(id).orElse(null);
    }
    public Iterable<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
    public void addTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }
    public void updateTransactionBudgetId(Long id, Long budgetId) throws Exception{
        final var transaction = transactionRepo.findTransactionById(id).orElse(null);
        if(transaction == null)
            throw new Exception();
        transaction.budgetId = budgetId;
        transactionRepo.save(transaction);
    }

    public void deleteTransactionById(Long id) throws Exception{
        final var transaction = transactionRepo.findTransactionById(id).orElse(null);
        if(transaction == null)
            throw new Exception();
        transactionRepo.deleteTransactionById(id);
    }
}
