package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "walet")
@Setter
@Getter
public class Walet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwalet", nullable = false)
    private Integer idwalet;
    @Column(name = "public", nullable = false)
    private String publicKey;
    @Column(name = "private", nullable = false)
    private String privateKey;

    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idwalet")
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "idwalet")
    private Set<Nft> nfts = new LinkedHashSet<>();
}