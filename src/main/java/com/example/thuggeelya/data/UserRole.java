package com.example.thuggeelya.data;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name = "userrole")
public class UserRole {

    @EmbeddedId
    private UserRoleKey key;
}
