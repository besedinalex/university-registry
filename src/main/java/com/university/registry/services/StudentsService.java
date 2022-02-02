package com.university.registry.services;

import com.university.registry.dtos.NewStudentDto;
import com.university.registry.exceptions.GroupNotFoundException;
import com.university.registry.models.Student;
import com.university.registry.repositories.GroupsRepository;
import com.university.registry.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;
    private final GroupsRepository groupsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository, GroupsRepository groupsRepository) {
        this.studentsRepository = studentsRepository;
        this.groupsRepository = groupsRepository;
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public List<Student> getStudentsByGroup(long groupId) {
        var group = groupsRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(groupId));
        return studentsRepository.findByGroup(group).orElseThrow();
    }

    public Student addNewStudent(long groupId, Student student) {
        var group = groupsRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(groupId));
        student.setGroup(group);
        return studentsRepository.save(student);
    }
}