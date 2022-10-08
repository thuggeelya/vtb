package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtag", nullable = false)
    private Integer idtag;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "usertag",
            joinColumns = @JoinColumn(name = "idtag"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    private Set<User> users = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "activitytag",
            joinColumns = @JoinColumn(name = "idtag"),
            inverseJoinColumns = @JoinColumn(name = "idactivity"))
    private Set<Activity> activities = new LinkedHashSet<>();

}