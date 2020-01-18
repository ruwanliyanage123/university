package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.SubjectRepository;
import com.example.backend.admin.models.Student;
import com.example.backend.admin.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    /**
     * to invoke save method in jpa
     * @param subject
     * @return inserted student
     */
    public Subject addStudent(Subject subject){
        return subjectRepository.save(subject);
    }

}
