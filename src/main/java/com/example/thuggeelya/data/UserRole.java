package com.example.thuggeelya.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "userrole")
public class UserRole {

    @EmbeddedId
    private UserRoleKey key;
}
