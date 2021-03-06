package com.example.backend.admin.controllers;

import com.example.backend.admin.exceptions.StudentNotFoundException;
import com.example.backend.admin.exceptions.SubjectNotFoundException;
import com.example.backend.admin.models.Student;
import com.example.backend.admin.models.Subject;
import com.example.backend.admin.services.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    /**
     * to retrieve one subject
     * @param subjectId subject id
     * @return selected subject
     */
    @GetMapping("/one/{subjectId}")
    public Subject getOneSubject(@PathVariable int subjectId){
        Subject subject= null;
        try {
            subject = subjectService.getOneSubject(subjectId);
        } catch (SubjectNotFoundException e) {
            logger.error("Subject not in database. re check the subject id", e);
        }
        return subject;
    }

    @DeleteMapping("/delete/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable int subjectId){
        Subject subject = null;
        try {
            subject = subjectService.getOneSubject(subjectId);
        } catch (SubjectNotFoundException e) {
            logger.error("Student not in database. re check the student id number", e);
        }
        return subjectService.deleteSubject(subject);
    }

    /**
     * to update subject
     * @param subjectId subject id
     * @param subject subject
     * @return updated subject
     */
    @PutMapping("/update/{subjectId}")
    public Subject updateSubject(@PathVariable int subjectId, @RequestBody Subject subject){
        Subject subject1 = null;
        try {
            subject1 = subjectService.getOneSubject(subjectId);
        } catch (SubjectNotFoundException e) {
            logger.error("subject not in database. re check the subject id number", e);
        }
        assert subject1 != null;
        subject1.setSubjectName(subject.getSubjectName());
        subject1.setNumberOfCredits(subject.getNumberOfCredits());
        return subjectService.updateSubject(subject1);
    }
}
