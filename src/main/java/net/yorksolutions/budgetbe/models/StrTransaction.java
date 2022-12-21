package net.yorksolutions.budgetbe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StrTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String partyName;
    public Long amount;
    public String accountName;
    public String budgetName;

    public StrTransaction(Long id, String partyName, Long amount, String accountName, String budgetName) {
        this.id = id;
        this.partyName = partyName;
        this.amount = amount;
        this.accountName = accountName;
        this.budgetName = budgetName;
    }

    public StrTransaction() {

    }
}
