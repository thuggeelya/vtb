package com.example.thuggeelya.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class UserRoleKey implements Serializable {

    private Integer iduser;
    private Integer idrole;
}
