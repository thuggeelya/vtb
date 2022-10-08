package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlevel", nullable = false)
    private Integer id;

    @Column(name = "maxexp", nullable = false)
    private Integer maxexp;

    @OneToMany(mappedBy = "idevel")
    private Set<Userlevel> userlevels = new LinkedHashSet<>();

}