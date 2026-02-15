package com.xworkz.module.service.admin.student;

import com.xworkz.module.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    boolean validateAndSaveStudents(StudentDto studentDto);

    List<StudentDto> getStudentList();

    List<StudentDto> getStudentsByBatchId(int batchId);

    Optional<StudentDto> editStudent(int studentId);

    boolean updateStudent(StudentDto studentDto);

    boolean deleteStudentById(int studentId);
}
