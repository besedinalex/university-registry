package com.university.registry.controllers;

import com.university.registry.dtos.NewStudentDto;
import com.university.registry.dtos.StudentByGroupDto;
import com.university.registry.models.Student;
import com.university.registry.services.StudentsService;
import com.university.registry.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentsController {

    private final StudentsService studentsService;
    private final MappingUtils mappingUtils;

    @Autowired
    public StudentsController(StudentsService studentsService, MappingUtils mappingUtils) {
        this.studentsService = studentsService;
        this.mappingUtils = mappingUtils;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        var students = studentsService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("{groupId}")
    public ResponseEntity<List<StudentByGroupDto>> getStudentsByGroup(@PathVariable long groupId) {
        var students = studentsService.getStudentsByGroup(groupId)
                .stream().map(mappingUtils::mapToStudentsByGroup).collect(Collectors.toList());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Student> addNewStudent(@RequestBody NewStudentDto newStudent) {
        var groupId = newStudent.getGroupId();
        var student = mappingUtils.mapToStudent(newStudent);
        student = studentsService.addNewStudent(groupId, student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}