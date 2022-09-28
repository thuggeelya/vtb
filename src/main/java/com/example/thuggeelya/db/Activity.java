package com.example.thuggeelya.db;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idactivity;
    private String name;
    private String reward;

    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Temporal(TemporalType.DATE)
    private Date finishdate;
}
