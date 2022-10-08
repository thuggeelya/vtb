package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iduser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "userlevel")
public class Userlevel {
    @Id
    @Column(name = "iduser", nullable = false)
    private Integer iduser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idevel")
    private Level idevel;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @Column(name = "currentexp", nullable = false)
    private Integer currentexp;

}