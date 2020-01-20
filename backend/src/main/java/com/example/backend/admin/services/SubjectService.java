package com.example.backend.admin.services;

import com.example.backend.admin.Repositories.SubjectRepository;
import com.example.backend.admin.exceptions.SubjectNotFoundException;
import com.example.backend.admin.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    /**
     * to invoke save method in jpa
     * @param subject
     * @return inserted subject
     */
    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    /**
     * to invoke find all method in jpa
     * @return list of subject
     */
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    /**
     * to invoke find single method in jpa
     * @param subjectId subject id
     * @return selected subject
     * @throws SubjectNotFoundException when student not in database
     */
    public Subject getOneSubject(int subjectId) throws SubjectNotFoundException {
        return subjectRepository.findById(subjectId)
                .orElseThrow(()->new SubjectNotFoundException());
    }

    /**
     * to invoke delete method in jpa
     * @param subject subject
     * @return response
     */
    public ResponseEntity<?> deleteSubject(Subject subject){
        subjectRepository.delete(subject);
        return ResponseEntity.ok().build();
    }

    /**
     * to invoke update method in jpa
     * @param  subject subject
     * @return selected subject
     */
    public Subject updateSubject(Subject subject){
        return subjectRepository.save(subject);
    }
}
