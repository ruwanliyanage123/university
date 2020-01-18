package com.example.backend.admin.Repositories;

import com.example.backend.admin.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposiroty extends JpaRepository<Student, Integer> {

}
