package com.example.thuggeelya.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iduser")
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loginform")
public class LoginForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer iduser;
    @Getter
    @Column(name = "login")
    private String username;
    @Getter
    private String password;
//
//    @JsonIgnore
//    @NotFound(action = NotFoundAction.IGNORE)
//    @org.springframework.data.annotation.Transient
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @Setter
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "iduser")
//    @ToString.Exclude
//    @PrimaryKeyJoinColumn
//    private User user;
//
//    @JsonIgnore
////    @JsonManagedReference
//    public User getUser() {
//        return user;
//    }

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
