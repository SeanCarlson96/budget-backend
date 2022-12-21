package net.yorksolutions.budgetbe.services;

import net.yorksolutions.budgetbe.models.Account;
import net.yorksolutions.budgetbe.repositories.AccountRepository;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
    private final AccountRepository accountRepo;
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account getAccountById(Long id){
        return accountRepo.findAccountById(id).orElse(null);
    }
    public Iterable<Account> getAllAccounts(){
        return accountRepo.findAll();
    }
    public void addAccount(Account newAccount){
        accountRepo.save(newAccount);
    }
    public void updateAccountBalance(Long id, Long balance) throws Exception {
        final var account = accountRepo.findAccountById(id).orElse(null);
        if(account == null)
            throw new Exception();
        account.balance = balance;
        accountRepo.save(account);
    }
}
