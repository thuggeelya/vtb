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
public class ActivitytagId implements Serializable {
    private static final long serialVersionUID = -7916390447418475773L;
    @Column(name = "idactivity", nullable = false)
    private Integer idactivity;
    @Column(name = "idtag", nullable = false)
    private Integer idtag;

    @Override
    public int hashCode() {
        return Objects.hash(idtag, idactivity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ActivitytagId entity = (ActivitytagId) o;
        return Objects.equals(this.idtag, entity.idtag) &&
                Objects.equals(this.idactivity, entity.idactivity);
    }
}