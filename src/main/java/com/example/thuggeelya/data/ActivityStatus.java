package com.example.thuggeelya.data;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "activitystatus")
public class ActivityStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivitystatus", nullable = false)
    private Integer idactivitystatus;

    @Getter
    @Setter
    @Column(name = "statusname", nullable = false)
    private String statusname;

    public Integer getIdactivitystatus() {
        return idactivitystatus;
    }

    public void setIdactivitystatus(Integer idactivitystatus) {
        this.idactivitystatus = idactivitystatus;
    }

    @Transient
    private static ActivityStatus PASSED = null;
    @Transient
    private static ActivityStatus CURRENT = null;
    @Transient
    private static ActivityStatus FURTHER = null;

    public static ActivityStatus getPASSED() {
        if (PASSED == null) {
            PASSED = new ActivityStatus(ActivityStatusEnum.PASSED.getId(), "PASSED");
        }

        return PASSED;
    }

    public static ActivityStatus getCURRENT() {
        if (CURRENT == null) {
            CURRENT = new ActivityStatus(ActivityStatusEnum.CURRENT.getId(), "CURRENT");
        }

        return CURRENT;
    }

    public static ActivityStatus getFURTHER() {
        if (FURTHER == null) {
            FURTHER = new ActivityStatus(ActivityStatusEnum.FURTHER.getId(), "FURTHER");
        }

        return FURTHER;
    }
}