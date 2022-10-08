package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    //    @JsonBackReference
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idwalet", nullable = true)
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

    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @Transient
    @OneToMany(mappedBy = "sender")
    private Set<Transaction> transactionsAsSender = new LinkedHashSet<>();

    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @OneToMany(mappedBy = "accepter")
    private Set<Transaction> transactionsAsAccepter = new LinkedHashSet<>();

//    @NotFound(action = NotFoundAction.IGNORE)
//    @JsonIgnore
//    @org.springframework.data.annotation.Transient
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @Setter
//    private LoginForm loginform;
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

    public User(String lastname,
                String name,
                String patronymic,
                String email,
                String phone,
                Integer balance,
                Integer monthrate,
                Set<Role> roles) {
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.monthrate = monthrate;
        this.roles = roles;
    }
//
//    @JsonIgnore
////    @JsonBackReference
//    public LoginForm getLoginform() {
//        return loginform;
//    }
}