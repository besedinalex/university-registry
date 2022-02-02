package com.university.registry.repositories;

import com.university.registry.models.Group;
import com.university.registry.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Student, Long> {

    Optional<List<Student>> findByGroup(Group group);
}