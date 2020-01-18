package com.example.backend.admin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

    @Entity
    @Table(name = "lecturers")
    public class Lecturer extends Staff {

        @Column(name = "lecture_hours", nullable = false)
        private int lectureHours;

        public int getLectureHours() {
            return lectureHours;
        }

        public void setLectureHours(int lectureHours) {
            this.lectureHours = lectureHours;
        }
    }

