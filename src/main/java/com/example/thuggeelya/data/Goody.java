package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class Goody {

    @ManyToMany
    @JoinTable(name = "ordergoody",
            joinColumns = @JoinColumn(
                    name = "idgoody",
                    referencedColumnName = "idgoody"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idorder",
                    referencedColumnName = "idorder"
            ))
    @ToString.Exclude
    private final List<Order> orders = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgoody;
    private String description;
    private String name;
    private Integer price;
}
