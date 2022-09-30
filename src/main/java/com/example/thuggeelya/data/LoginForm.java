package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loginform")
public class LoginForm implements Serializable {

    @Id
    private Integer iduser;
    private String login;
    private String password;

    @OneToOne
    @Transient
    @JoinColumn(name = "iduser")
    private User user;
}
