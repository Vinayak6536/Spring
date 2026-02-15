package com.xworkz.module.service.admin.student.impl;

import com.xworkz.module.dto.StudentDto;
import com.xworkz.module.entity.StudentEntity;
import com.xworkz.module.repository.admin.student.StudentRepository;
import com.xworkz.module.service.admin.student.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentEntity studentEntity;

    @Override
    public boolean validateAndSaveStudents(StudentDto studentDto) {
        if (studentDto != null) {
            BeanUtils.copyProperties(studentDto, studentEntity);
            studentRepository.saveStudents(studentEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentDto> getStudentList() {

        System.out.println("get in service...");

        List<StudentEntity> studentsList = studentRepository.getStudentsList();

//        System.out.println(studentsList);

        List<StudentDto> list = new ArrayList<>();

        for (StudentEntity student : studentsList) {
            if (student.isActive()) {
                StudentDto studentDto = new StudentDto();
                BeanUtils.copyProperties(student, studentDto);
                list.add(studentDto);

            }

        }

        return list;
    }

    @Override
    public List<StudentDto> getStudentsByBatchId(int batchId) {
        if (batchId != 0) {
            List<StudentEntity> studentEntity = studentRepository.getStudentsByBatchId(batchId);

            List<StudentDto> list = new ArrayList<>();
            for (StudentEntity student : studentEntity) {
                if (student.isActive()) {
                    StudentDto studentDto = new StudentDto();
                    BeanUtils.copyProperties(student, studentDto);
                    list.add(studentDto);
                }
            }
            return list;
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<StudentDto> editStudent(int studentId) {
        Optional<StudentEntity> editStudent=studentRepository.editStudentDetails(studentId);
        if (editStudent.isPresent()) {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(editStudent.get(), studentDto);
           // System.out.println(studentDto);
            return Optional.of(studentDto);
        }
        return Optional.empty();
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) {
        if (studentDto != null) {
            BeanUtils.copyProperties(studentDto,studentEntity);
            boolean updated=studentRepository.updateStudentDetails(studentEntity);
            return updated;
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(int studentId) {
        if (studentId != 0){
           boolean deleted= studentRepository.deleteStudentById(studentId);
           if (deleted){
               return true;
           }
        }
        return false;
    }
}
