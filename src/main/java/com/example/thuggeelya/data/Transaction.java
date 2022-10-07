package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtransaction;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Integer sum;
    private Integer fee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idaccepter")
    private User accepter;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idsender")
    private User sender;
}
