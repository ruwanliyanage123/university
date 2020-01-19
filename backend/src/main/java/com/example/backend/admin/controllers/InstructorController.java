package com.example.backend.admin.controllers;

import com.example.backend.admin.models.Instructor;
import com.example.backend.admin.models.Lecturer;
import com.example.backend.admin.services.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
