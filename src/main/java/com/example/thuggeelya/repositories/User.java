package com.example.thuggeelya.repositories;

import com.example.thuggeelya.db.Order;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@Table(name = "user")
public class User {

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

    @OneToMany(mappedBy = "idorder")
    @ToString.Exclude
    private final List<Order> orders = new ArrayList<>();

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(iduser);
        sb.append(", email='").append(email).append("'");
        sb.append(", lastName='").append(lastname).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", patronymic='").append(patronymic).append("'");
        sb.append(", balance='").append(balance).append("'");
        sb.append(", phone='").append(phone).append("'");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, email);
    }
}