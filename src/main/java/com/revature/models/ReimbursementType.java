package com.revature.models;

public class ReimbursementType {
    private short id;
    private String type;

    public ReimbursementType() {
    }

    public ReimbursementType(short id, String type) {
        this.id = id;
        this.type = type;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}