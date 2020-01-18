package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.StudentReposiroty;
import com.example.backend.admin.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service class for student
 */
@Service
public class StudentService {
    @Autowired
    StudentReposiroty studentReposiroty;

    /**
     * to invoke save method in jpa
     * @param student new student
     * @return inserted student
     */
    public Student addStudent(Student student){
        return studentReposiroty.save(student);
    }
}
