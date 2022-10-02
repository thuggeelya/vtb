package com.example.thuggeelya.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class OrderGoodyKey implements Serializable {

    private Integer idorder;
    private Integer idgoody;
}
