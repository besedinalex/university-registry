package com.university.registry.utils;

import com.university.registry.dtos.NewStudentDto;
import com.university.registry.dtos.StudentByGroupDto;
import com.university.registry.models.Student;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public StudentByGroupDto mapToStudentsByGroup(Student student) {
        var studentDto = new StudentByGroupDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setAdmissionDate(student.getAdmissionDate());
        return studentDto;
    }

    public Student mapToStudent(NewStudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAdmissionDate(studentDto.getAdmissionDate());
        return student;
    }
}