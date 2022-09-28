package com.example.thuggeelya.repositories;

import com.example.thuggeelya.data.Activity;
import com.example.thuggeelya.data.Order;
import com.example.thuggeelya.data.Role;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "user")
@ToString
public class User {

    @OneToMany(mappedBy = "idorder")
    @ToString.Exclude
    private final List<Order> orders = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "useractivity",
            joinColumns = @JoinColumn(
                    name = "iduser",
                    referencedColumnName = "iduser"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idactivity",
                    referencedColumnName = "idactivity"
            ))
    @ToString.Exclude
    private final List<Activity> activities = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Integer iduser;
    private String email;
    private Integer balance;
    private String lastname;
    private String name;
    private String patronymic;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    @Transient
    @ToString.Exclude
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(
                    name = "iduser",
                    referencedColumnName = "iduser"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idrole",
                    referencedColumnName = "idrole"
            )
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String email) {
        this.email = email;
        lastname = "";
        name = "";
        patronymic = "";
        balance = 100;
        phone = "";
    }
}