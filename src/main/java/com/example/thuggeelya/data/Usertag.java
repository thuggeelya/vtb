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
@Table(name = "usertag")
public class Usertag {
    @EmbeddedId
    private UsertagId id;

    @MapsId("idtag")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtag", nullable = false)
    private Tag idtag;

    @MapsId("iduser")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

}