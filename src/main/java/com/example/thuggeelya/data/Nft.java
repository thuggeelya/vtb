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
@Table(name = "nft")
public class Nft {
    @Id
    @Column(name = "tokenId", nullable = false)
    private Integer id;

    @Column(name = "uri", nullable = false, length = 100)
    private String uri;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idwalet", nullable = false)
    private Walet idwalet;

}