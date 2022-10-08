package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idactivity")
@Entity
@JsonSerialize
@NoArgsConstructor
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivity", nullable = false)
    private Integer idactivity;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivitystatus", nullable = false)
    private ActivityStatus status;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcreator")
    private User creator;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "useractivity",
            joinColumns = @JoinColumn(name = "idactivity"),
            inverseJoinColumns = @JoinColumn(name = "iduser"))
    private Set<User> users = new LinkedHashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public LocalDate getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(LocalDate datefinish) {
        this.datefinish = datefinish;
    }

    public LocalDate getDatestart() {
        return datestart;
    }

    public void setDatestart(LocalDate datestart) {
        this.datestart = datestart;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdactivity() {
        return idactivity;
    }

    public void setIdactivity(Integer idactivity) {
        this.idactivity = idactivity;
    }
}