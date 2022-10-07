package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "activitystatus")
public class ActivityStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivitystatus", nullable = false)
    private Integer idactivitystatus;

    @Getter
    @Setter
    @Column(name = "statusname", nullable = false)
    private String statusname;

    public Integer getIdactivitystatus() {
        return idactivitystatus;
    }

    public void setIdactivitystatus(Integer idactivitystatus) {
        this.idactivitystatus = idactivitystatus;
    }
}