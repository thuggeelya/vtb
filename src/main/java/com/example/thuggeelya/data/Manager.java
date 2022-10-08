package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmanager", nullable = false)
    private Integer idmanager;

    @JsonBackReference
    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idmanager", nullable = false)
    private User user;

    @Getter
    @Setter
    @Transient
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private Set<User> iduser = new LinkedHashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(Integer idmanager) {
        this.idmanager = idmanager;
    }
}