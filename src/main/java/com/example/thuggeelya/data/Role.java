package com.example.thuggeelya.data;

import com.example.thuggeelya.repositories.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrole;
    private String name;

    @Transient
    @ManyToMany
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(
                    name = "idrole",
                    referencedColumnName = "idrole"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "iduser",
                    referencedColumnName = "iduser"
            )
    )
    @ToString.Exclude
    private Set<User> users;
}
