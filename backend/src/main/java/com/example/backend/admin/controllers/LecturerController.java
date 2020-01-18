package com.example.backend.admin.controllers;

import com.example.backend.admin.models.Lecturer;
import com.example.backend.admin.models.Student;
import com.example.backend.admin.services.LecturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller class for the lecturer
 */
@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    private static Logger logger = LoggerFactory.getLogger(LecturerController.class);
    @Autowired
    LecturerService lecturerService;

    /**
     * to insert a new lecturer
     * @param lecturer new lecturer
     * @return insert lecturer
     */
    @PostMapping("/add")
    public Lecturer addLecturer(@RequestBody Lecturer lecturer) {
        Lecturer lecturer1 = null;
        try {
            lecturer1 = lecturerService.addLecturer(lecturer);
        } catch (NullPointerException e) {
            logger.error("check the payload, null pointer is throwing", e);
        }
        return lecturer1;
    }

    /**
     * to retrieve all lecturers
     * @return list of lecturers
     */
    @GetMapping("/all")
    public List<Lecturer> getAllLecturer(){
        List<Lecturer> lecturers = null;
        try {
            lecturers = lecturerService.getAllLecturer();
        }catch (NullPointerException e){
            logger.error("Null pointer due to Student list. Check database connections", e);
        }
        return lecturers;
    }

}