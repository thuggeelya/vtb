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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpayment;

    @OneToOne
    @JoinColumn(name = "order")
    private Order order;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
