package com.example.backend.admin.controllers;

import com.example.backend.admin.models.Student;
import com.example.backend.admin.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/students") public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    StudentService studentService;

    @PostMapping("/add") public Student addStudent(@RequestBody Student student) {
        Student student1 = null;
        try {
            student1 = studentService.addStudent(student);
        } catch (NullPointerException e) {
            logger.error("check the payload, null pointer is throwing", e);
        }
        return student1;
    }
}
