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
@Table(name = "userlevel")
public class Userlevel {
    @Id
    @Column(name = "iduser", nullable = false)
    private Integer iduser;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @Column(name = "nlevel", nullable = false)
    private Integer nlevel;

    @Column(name = "exp", nullable = false)
    private Integer exp;

}