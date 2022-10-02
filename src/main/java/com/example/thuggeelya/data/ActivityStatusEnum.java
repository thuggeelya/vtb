package com.example.thuggeelya.data;

public enum ActivityStatusEnum {
    PASSED(1), CURRENT(2), FURTHER(3);

    private int id;

    ActivityStatusEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
