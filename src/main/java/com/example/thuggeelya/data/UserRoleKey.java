package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
@NoArgsConstructor
public class UserRoleKey {

    private Integer iduser;
    private Integer idrole;
}
