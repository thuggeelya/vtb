package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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

    //    @Transient
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    @Setter
    private LoginForm loginform;
    @Getter
    @Setter
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
    @Transient
    @JoinTable(name = "manager",
            joinColumns = @JoinColumn(name = "idmanager"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    private Set<User> managers = new LinkedHashSet<>();
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Userlevel userlevel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
    @ToString.Exclude
    private Set<Activity> acases = new LinkedHashSet<>();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "iduser")
    private List<Comment> comments = new ArrayList<>();

    public User(Integer iduser,
                String lastname,
                String name,
                String patronymic,
                String email,
                String phone,
                Integer balance,
                Integer monthrate,
                LoginForm loginform,
                Set<Role> roles) {
        this.iduser = iduser;
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.monthrate = monthrate;
        this.loginform = loginform;
        this.roles = roles;
    }

    @JsonIgnore
//    @JsonBackReference
    public LoginForm getLoginform() {
        return loginform;
    }
}