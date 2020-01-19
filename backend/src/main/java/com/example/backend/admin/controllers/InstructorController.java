package com.example.backend.admin.controllers;

import com.example.backend.admin.exceptions.InstructorNotFoundException;
import com.example.backend.admin.exceptions.LecturerNotFoundException;
import com.example.backend.admin.models.Instructor;
import com.example.backend.admin.models.Lecturer;
import com.example.backend.admin.services.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * constructor for the instructor
 */
@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private static Logger logger = LoggerFactory.getLogger(InstructorController.class);
    @Autowired
    InstructorService instructorService;

    /**
     * to insert a new instructor
     * @param instructor new instructor
     * @return insert instructor
     */
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        Instructor instructor1 = null;
        try {
            instructor1 = instructorService.addInstructor(instructor);
        } catch (NullPointerException e) {
            logger.error("check the payload, null pointer is throwing", e);
        }
        return instructor1;
    }

    /**
     * to retrieve all instructor
     * @return list of instructor
     */
    @GetMapping("/all")
    public List<Instructor> getAllInstructor(){
        List<Instructor> instructors = null;
        try {
            instructors = instructorService.getAllInstructor();
        }catch (NullPointerException e){
            logger.error("Null pointer due to Instructor list. Check database connections", e);
        }
        return instructors;
    }

    /**
     * to retrieve one instructor
     * @param instructorId instructor id
     * @return selected instructor
     */
    @GetMapping("/one/{instructorId}")
    public Instructor getOneInstructor(@PathVariable int instructorId){
        Instructor instructor = null;
        try {
            instructor = instructorService.getOneInstructor(instructorId);
        } catch (InstructorNotFoundException e) {
            logger.error("Instructor not in database. re check the instructor id number", e);
        }
        return instructor;
    }

    /**
     * to delete instructor
     * @param instructorId instructor id
     * @return response of request
     */
    @DeleteMapping("/delete/{instructorId}")
    public ResponseEntity<?> deleteInstructor(@PathVariable int instructorId){
        Instructor instructor = null;
        try {
            instructor = instructorService.getOneInstructor(instructorId);
        } catch (InstructorNotFoundException e) {
            logger.error("instructor not in database. re check the instructor id number", e);
        }
        return instructorService.deleteInstructor(instructor);
    }
}
