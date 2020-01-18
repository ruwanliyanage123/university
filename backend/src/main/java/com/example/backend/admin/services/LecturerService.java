package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.LecturerRepository;
import com.example.backend.admin.exceptions.LecturerNotFoundException;
import com.example.backend.admin.exceptions.StudentNotFoundException;
import com.example.backend.admin.models.Lecturer;
import com.example.backend.admin.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        /**
         * to invoke find all method in jpa
         * @return list of lecturer
         */
        public List<Lecturer> getAllLecturer(){
            return lecturerRepository.findAll();
        }

        /**
         * to invoke find single method in jpa
         * @param lecturerId lecturer id
         * @return selected lecturer
         * @throws LecturerNotFoundException when lecturer not in database
         */
        public Lecturer getOneLecturer(int lecturerId) throws LecturerNotFoundException {
            return lecturerRepository.findById(lecturerId)
                    .orElseThrow(()->new LecturerNotFoundException());
        }
    }
