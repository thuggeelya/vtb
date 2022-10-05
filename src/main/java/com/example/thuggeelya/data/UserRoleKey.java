package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleKey implements Serializable {

    private Integer iduser;
    private Integer idrole;
}
