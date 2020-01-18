package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.StudentReposiroty;
import com.example.backend.admin.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * to invoke find all method in jpa
     * @return list of student
     */
    public List<Student> getAllStudent(){
        return studentReposiroty.findAll();
    }
}
