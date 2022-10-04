package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loginform")
public class LoginForm implements Serializable {

    @Id
    private Integer iduser;
    private String login;
    private String password;

    @JsonManagedReference
    @OneToOne
    @Transient
    @JoinColumn(name = "iduser")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LoginForm loginForm = (LoginForm) o;
        return iduser != null && Objects.equals(iduser, loginForm.iduser);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
