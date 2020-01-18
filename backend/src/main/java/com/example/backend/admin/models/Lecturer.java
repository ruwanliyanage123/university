package com.example.backend.admin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
public class Lecturer extends Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffID;

    private int lectureHours;

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }
}
