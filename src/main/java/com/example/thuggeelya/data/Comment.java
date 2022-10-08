package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomment", nullable = false)
    private Integer idcomment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idactivity", nullable = false)
    private Activity idactivity;

    @Column(name = "text", length = 250)
    private String text;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "nlikes", nullable = false)
    private Integer nlikes;
}