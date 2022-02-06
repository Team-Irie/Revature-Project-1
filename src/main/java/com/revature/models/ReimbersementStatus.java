package com.revature.models;

public class ReimbersementStatus {
    private short id;
    private String status;

    public ReimbersementStatus() {
    }

    public ReimbersementStatus(short id, String status) {
        this.id = id;
        this.status = status;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbersementStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}