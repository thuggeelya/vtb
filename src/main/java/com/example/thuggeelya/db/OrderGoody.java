package com.example.thuggeelya.db;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class OrderGoody {

    @EmbeddedId
    private OrderGoodyKey key;
    private Integer count;
}
