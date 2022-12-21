package net.yorksolutions.budgetbe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public Integer partyId;
    public Long amount;
    public Long accountId;
    public Long budgetId;

    public Transaction(Long id, Integer partyId, Long amount, Long accountId, Long budgetId) {
        this.id = id;
        this.partyId = partyId;
        this.amount = amount;
        this.accountId = accountId;
        this.budgetId = budgetId;
    }

    public Transaction() {

    }
}