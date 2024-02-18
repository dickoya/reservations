package com.reservations.reservations.models;

public enum Role{

    MEMBER("MEMBER", "member"),
    ADMIN("ADMIN", "admin");

    private final String key;
    private final String value;

    Role(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
