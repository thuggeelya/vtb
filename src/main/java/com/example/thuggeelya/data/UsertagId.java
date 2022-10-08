package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class UsertagId implements Serializable {
    private static final long serialVersionUID = 3782844733005262126L;
    @Column(name = "idtag", nullable = false)
    private Integer idtag;
    @Column(name = "iduser", nullable = false)
    private Integer iduser;

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsertagId entity = (UsertagId) o;
        return Objects.equals(this.iduser, entity.iduser) &&
                Objects.equals(this.idtag, entity.idtag);
    }
}