package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

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
    private final Set<Role> roles = new HashSet<>();
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
    @Nullable
    @Temporal(TemporalType.DATE)
    private Date datebalancing;
    @JsonManagedReference
    @ManyToOne
    @Transient
    @JoinColumn(name = "idmanager")
    private Manager manager;
    @JsonBackReference
    @OneToOne
    @Transient
    @JoinColumn(name = "iduser")
    private LoginForm loginForm;

    public User() {
    }

    public User(String email) {
        this.email = email;
        lastname = "";
        name = "";
        patronymic = "";
        balance = 100;
        phone = "";
        datebalancing = null;
    }
}