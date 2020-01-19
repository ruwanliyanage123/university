package com.example.backend.admin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor extends Staff {
    private int practicalHours;

    @Column(name = "practical_hours", nullable = false)
    public int getPracticalHours() {
        return practicalHours;
    }

    public void setPracticalHours(int practicalHours) {
        this.practicalHours = practicalHours;
    }
}
