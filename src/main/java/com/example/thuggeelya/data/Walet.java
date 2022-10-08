package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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

    @JsonIgnore
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idwalet")
    @ToString.Exclude
    @Setter
    @Getter
    private User user;

    public Integer getIdwalet() {
        return idwalet;
    }

    public void setIdwalet(Integer idwalet) {
        this.idwalet = idwalet;
    }
}