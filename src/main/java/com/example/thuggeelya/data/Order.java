package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class Order {

    @ManyToMany
    @JoinTable(name = "ordergoody",
            joinColumns = @JoinColumn(
                    name = "idorder",
                    referencedColumnName = "idorder"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idgoody",
                    referencedColumnName = "idgoody"
            ))
    @ToString.Exclude
    private final List<Goody> goodies = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorder;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @Temporal(TemporalType.DATE)
    private Date editdate;
}
