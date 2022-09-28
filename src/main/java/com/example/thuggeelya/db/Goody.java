package com.example.thuggeelya.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class Goody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgoody;
    private String description;
    private String name;
    private Integer price;

    @ManyToMany
    @JoinTable(name = "ordergoody",
            joinColumns = @JoinColumn(
                    name = "idgoody",
                    referencedColumnName = "idgoody"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idorder",
                    referencedColumnName = "idorder"
            ))
    @ToString.Exclude
    private final List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Goody{");
        sb.append("id=").append(idgoody);
        sb.append(", name='").append(name).append("'");
        sb.append(", price='").append(price).append("'");
        sb.append(", description='").append(description).append("'");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgoody, name);
    }
}
