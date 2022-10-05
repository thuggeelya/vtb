package com.example.thuggeelya.data;

public enum RoleEnum {
    ROLE_ADMIN(1), ROLE_USER(2), ROLE_ANON(3);

    private int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
