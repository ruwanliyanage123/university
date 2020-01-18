package com.example.backend.admin.controllers;

import com.example.backend.admin.exceptions.StudentNotFoundException;
import com.example.backend.admin.models.Student;
import com.example.backend.admin.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller class for the student
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    /**
     * to insert a new student
     * @param student new student
     * @return insert student
     */
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        Student student1 = null;
        try {
            student1 = studentService.addStudent(student);
        } catch (NullPointerException e) {
            logger.error("check the payload, null pointer is throwing", e);
        }
        return student1;
    }

    /**
     * to retrieve all students
     * @return list of students
     */
    @GetMapping("/all")
    public List<Student> getAllStudent(){
        List<Student> students = null;
        try {
            students = studentService.getAllStudent();
        }catch (NullPointerException e){
            logger.error("Null pointer due to Student list. Check database connections", e);
        }
        return students;
    }

    /**
     * to retrieve one student
     * @param studentId student id
     * @return selected student
     */
    @GetMapping("/one/{studentId}")
    public Student getOneStudent(@PathVariable int studentId){
        Student student = null;
        try {
            student = studentService.getOneStudent(studentId);
        } catch (StudentNotFoundException e) {
            logger.error("Student not in database. re check the student id number", e);
        }
        return student;
    }

    @DeleteMapping("/delete/{studentId}")
    public Student deleteStudent(@PathVariable int studentId){
        Student student = null;
        try {
            student = studentService.deleteStudent(studentId);
        } catch (StudentNotFoundException e) {
            logger.error("Student not in database. re check the student id number", e);
        }
        return student;
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student){
        Student student1 = null;
        try {
            student1 = studentService.getOneStudent(studentId);
        } catch (StudentNotFoundException e) {
            logger.error("Student not in database. re check the student id number", e);
        }
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setMobile(student.getMobile());
        student1.setEmail(student.getEmail());
        student1.setCity(student.getCity());
        student1.setStreet(student.getStreet());
        return studentService.updateStudent(student1);
    }
}
