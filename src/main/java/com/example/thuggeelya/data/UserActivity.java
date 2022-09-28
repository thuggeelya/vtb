package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "useractivity")
@Getter
@NoArgsConstructor
public class UserActivity {

    @EmbeddedId
    private UserActivityKey key;
}
