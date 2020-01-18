package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.StudentReposiroty;
import com.example.backend.admin.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    StudentReposiroty studentReposiroty;

    public Student addStudent(Student student){
        return studentReposiroty.save(student);
    }
}
