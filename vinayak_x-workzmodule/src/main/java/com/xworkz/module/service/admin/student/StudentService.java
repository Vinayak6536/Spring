package com.xworkz.module.service.admin.student;

import com.xworkz.module.dto.StudentDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    boolean validateAndSaveStudents(StudentDto studentDto) throws IOException;

    List<StudentDto> getStudentList();

    List<StudentDto> getStudentsByBatchId(int batchId);

    Optional<StudentDto> editStudent(int studentId);

    boolean updateStudent(StudentDto studentDto) throws IOException;

    boolean deleteStudentById(int studentId);
}
