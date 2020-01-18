package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.LecturerRepository;
import com.example.backend.admin.models.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * service class for lecturer
 */
    @Service
    public class LecturerService {
        @Autowired
        LecturerRepository lecturerRepository;

        /**
         * to invoke save method in jpa
         * @param lecturer new lecturer
         * @return inserted lecturer
         */
        public Lecturer addLecturer(Lecturer lecturer){
            return lecturerRepository.save(lecturer);
        }
    }
