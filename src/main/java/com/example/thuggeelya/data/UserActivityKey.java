package com.example.thuggeelya.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class UserActivityKey implements Serializable {

    private Integer iduser;
    private Integer idactivity;
}
