package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iduser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    private Integer iduser;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "patronymic", length = 45)
    private String patronymic;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "datebalancing")
    private LocalDate datebalancing;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idwalet")
    private Walet idwalet;

    @Column(name = "monthrate", nullable = false)
    private Integer monthrate;

    @JsonManagedReference
    @ManyToMany
    @Transient
    @JoinTable(name = "usertag",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idtag"))
    private Set<Tag> tags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sender")
    private Set<Transaction> transactionsAsSender = new LinkedHashSet<>();

    @OneToMany(mappedBy = "accepter")
    private Set<Transaction> transactionsAsAccepter = new LinkedHashSet<>();

    @JsonSerialize
    @Transient
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    private LoginForm loginform;
    @ManyToMany
    @JoinTable(name = "userrole",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idrole"))
    @ToString.Exclude
    private Set<Role> roles = new LinkedHashSet<>();
    @JsonManagedReference
    @ManyToMany
    @Transient
    @JoinTable(name = "useractivity",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idactivity"))
    @ToString.Exclude
    private Set<Activity> activities = new LinkedHashSet<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "iduser")
    @ToString.Exclude
    private Set<Order> orders = new LinkedHashSet<>();
    @ManyToMany
    @JoinTable(name = "manager",
            joinColumns = @JoinColumn(name = "idmanager"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    private Set<User> managers = new LinkedHashSet<>();
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Userlevel userlevel;

    @JsonIgnore
    @JsonBackReference
    public LoginForm getLoginform() {
        return loginform;
    }

}