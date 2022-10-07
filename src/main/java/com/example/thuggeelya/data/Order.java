package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder", nullable = false)
    private Integer idorder;

    @Column(name = "creationdate", nullable = false)
    private LocalDate creationdate;

    @Column(name = "editdate")
    private LocalDate editdate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

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
    private Set<Goody> goodies = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idorder")
    private Payment payments;

    public Payment getPayments() {
        return payments;
    }

    public void setPayments(Payment payments) {
        this.payments = payments;
    }

    public Set<Goody> getGoodies() {
        return goodies;
    }

    public void setGoodies(Set<Goody> goodies) {
        this.goodies = goodies;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public LocalDate getEditdate() {
        return editdate;
    }

    public void setEditdate(LocalDate editdate) {
        this.editdate = editdate;
    }

    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }
}