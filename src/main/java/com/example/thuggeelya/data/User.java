package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iduser")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @Column(name = "datebalancing", nullable = true)
    private LocalDate datebalancing;

    @OneToMany(mappedBy = "accepter")
    @ToString.Exclude
    private Set<Transaction> transactionsAsAccepter = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sender")
    @ToString.Exclude
    private Set<Transaction> transactionsAsSender = new LinkedHashSet<>();

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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idwalet")
    private Walet idwalet;

    @ManyToMany
    @JoinTable(name = "manager",
            joinColumns = @JoinColumn(name = "idmanager"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    @ToString.Exclude
    private Set<User> users = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "manager",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idmanager"))
    @ToString.Exclude
    private Set<User> users2 = new LinkedHashSet<>();

    public Walet getIdwalet() {
        return idwalet;
    }

    public Set<User> getUsers2() {
        return users2;
    }

    public void setUsers2(Set<User> users2) {
        this.users2 = users2;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @JsonBackReference
    public LoginForm getLoginform() {
        return loginform;
    }

    public void setLoginform(LoginForm loginform) {
        this.loginform = loginform;
    }

    public Set<Transaction> getTransactionsAsSender() {
        return transactionsAsSender;
    }

    public void setTransactionsAsSender(Set<Transaction> transactionsAsSender) {
        this.transactionsAsSender = transactionsAsSender;
    }

    public Set<Transaction> getTransactionsAsAccepter() {
        return transactionsAsAccepter;
    }

    public void setTransactionsAsAccepter(Set<Transaction> transactionsAsAccepter) {
        this.transactionsAsAccepter = transactionsAsAccepter;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
}