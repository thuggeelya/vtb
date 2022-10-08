package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idactivity")
@Entity
@JsonSerialize
@NoArgsConstructor
@Table(name = "activity")
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivity", nullable = false)
    private Integer idactivity;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivitystatus", nullable = false)
    private ActivityStatus status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivitytype", nullable = false)
    private ActivityType type;

    @Column(name = "datestart", nullable = false)
    private LocalDate datestart;

    @Column(name = "datefinish")
    private LocalDate datefinish;

    @Column(name = "reward", nullable = false, length = 45)
    private String reward;

    @Column(name = "description", length = 45)
    private String description;

    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcreator", unique = false)
    private User creator;

    @OneToMany(mappedBy = "idactivity")
    @JsonIgnore
    @org.springframework.data.annotation.Transient
    private Set<Comment> comments = new LinkedHashSet<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "useractivity",
            joinColumns = @JoinColumn(name = "idactivity"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    private Set<User> users = new LinkedHashSet<>();
}