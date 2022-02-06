package com.revature.models;

public class UserRoles {
    private short id;
    private String role;

    public UserRoles() {
    }

    public UserRoles(short id, String role) {
        this.id = id;
        this.role = role;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}