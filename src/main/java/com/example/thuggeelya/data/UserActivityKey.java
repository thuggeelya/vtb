package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
@NoArgsConstructor
public class UserActivityKey {

    private Integer iduser;
    private Integer idactivity;
}
