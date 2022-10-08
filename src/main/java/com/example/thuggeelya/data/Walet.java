package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "walet")
public class Walet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwalet", nullable = false)
    private Integer idwalet;
    @Column(name = "public", nullable = false)
    private String publicKey;
    @Column(name = "private", nullable = false)
    private String privateKey;

    public Integer getIdwalet() {
        return idwalet;
    }

    public void setIdwalet(Integer idwalet) {
        this.idwalet = idwalet;
    }
}