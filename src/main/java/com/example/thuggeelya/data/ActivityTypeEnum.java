package com.example.thuggeelya.data;

public enum ActivityTypeEnum {
    PROJECT(1), EVENT(2), COACHING(3), MENTORING(4), CASE(5);

    private int id;

    ActivityTypeEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
