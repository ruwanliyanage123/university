package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.InstructorRepository;
import com.example.backend.admin.models.Instructor;
import com.example.backend.admin.models.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service for the instructor
 */
@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    /**
     * to invoke save method in jpa
     * @param instructor new instructor
     * @return inserted instructor
     */
    public Instructor addInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    /**
     * to invoke find all method in jpa
     * @return list of instructor
     */
    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }
}
