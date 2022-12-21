package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
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
