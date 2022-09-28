package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@ToString
@Table(name = "ordergoody")
@NoArgsConstructor
public class OrderGoody {

    @EmbeddedId
    private OrderGoodyKey key;
    private Integer count;
}
