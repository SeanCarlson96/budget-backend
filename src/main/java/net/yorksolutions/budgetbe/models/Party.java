package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Party {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String name;
    @OneToMany
    public List<BudgetId> budgetIdList;

//    public Party(Long id, String name, List<BudgetId> budgetId) {
//        this.id = id;
//        this.name = name;
//        this.budgetId = budgetId;
//    }

//    public Party() {
//
//    }
}
