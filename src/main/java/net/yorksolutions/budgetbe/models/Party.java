package net.yorksolutions.budgetbe.models;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String name;
    public int[] budgetId;

    public Party(Long id, String name, int[] budgetId) {
        this.id = id;
        this.name = name;
        this.budgetId = budgetId;
    }

    public Party() {

    }
}
