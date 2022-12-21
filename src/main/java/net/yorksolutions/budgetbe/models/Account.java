package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String name;
    public String type;
    public Long balance;

    public Account(Long id, String name, String type, Long balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public Account() {

    }
}
