package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "ordergoody")
@NoArgsConstructor
public class OrderGoody {

    @EmbeddedId
    private OrderGoodyKey key;
    private Integer count;

    @MapsId("idorder")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorder")
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }
}
