package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Activity {

    @ManyToMany
    @JoinTable(name = "useractivity",
            joinColumns = @JoinColumn(
                    name = "idactivity",
                    referencedColumnName = "idactivity"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "iduser",
                    referencedColumnName = "iduser"
            ))
    @ToString.Exclude
    private final List<User> users = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idactivity;
    private String name;
    private String reward;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date datestart;
    @Temporal(TemporalType.DATE)
    private Date datefinish;
    @ManyToOne
    @JoinColumn(name = "idactivitytype")
    private ActivityType type;
    @ManyToOne
    @JoinColumn(name = "idactivitystatus")
    private ActivityStatus status;
}
