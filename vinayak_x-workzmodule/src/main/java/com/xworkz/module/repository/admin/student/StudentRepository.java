package com.xworkz.module.repository.admin.student;

import com.xworkz.module.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    boolean saveStudents(StudentEntity studentEntity);

    List<StudentEntity> getStudentsList();

    List<StudentEntity> getStudentsByBatchId(int batchId);

    Optional<StudentEntity> editStudentDetails(int studentId);

    boolean updateStudentDetails(StudentEntity studentEntity);

    boolean deleteStudentById(int studentId);
}
