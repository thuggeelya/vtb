package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iduser")
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loginform")
public class LoginForm implements Serializable {

    @Id
    @Getter
    private Integer iduser;
    @Getter
    private String login;
    @Getter
    private String password;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    @ToString.Exclude
    private User user;

    @JsonIgnore
    @JsonManagedReference
    public User getUser() {
        return user;
    }

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
