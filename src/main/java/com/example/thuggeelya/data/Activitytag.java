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
@Table(name = "activitytag")
public class Activitytag {
    @EmbeddedId
    private ActivitytagId id;

    @MapsId("idactivity")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivity", nullable = false)
    private Activity idactivity;

    @MapsId("idtag")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtag", nullable = false)
    private Tag idtag;

}