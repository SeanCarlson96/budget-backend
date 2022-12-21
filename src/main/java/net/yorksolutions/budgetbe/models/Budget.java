package net.yorksolutions.budgetbe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
    public Long total;
    public Long balance;

    public Budget(Long id, String name, Long total, Long balance) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.balance = balance;
    }

    public Budget() {

    }
}
