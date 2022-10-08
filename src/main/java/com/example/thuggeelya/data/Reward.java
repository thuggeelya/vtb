package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreward", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "rewardamount", nullable = false)
    private Integer rewardamount;

    @Column(name = "rewardunit", nullable = false, length = 45)
    private String rewardunit;

    @Column(name = "expamount")
    private Integer expamount;

}