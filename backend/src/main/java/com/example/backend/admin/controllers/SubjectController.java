package com.example.backend.admin.controllers;

import com.example.backend.admin.models.Student;
import com.example.backend.admin.models.Subject;
import com.example.backend.admin.services.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    SubjectService subjectService;

    /**
     * to insert a new subject
     * @param subject new subject
     * @return insert subject
     */
    @PostMapping("/add")
    public Subject addSubject(@RequestBody Subject subject) {
        Subject subject1 = null;
        try {
            subject1 = subjectService.addSubject(subject);
        } catch (NullPointerException e) {
            logger.error("check the payload, null pointer is throwing", e);
        }
        return subject1;
    }

    /**
     * to retrieve all subjects
     * @return list of subjects
     */
    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        List<Subject> subjects = null;
        try {
            subjects = subjectService.getAllSubject();
        }catch (NullPointerException e){
            logger.error("Null pointer due to Subject list. Check database connections", e);
        }
        return subjects;
    }
}
