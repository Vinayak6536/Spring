package com.xworkz.module.controller;

import com.xworkz.module.dto.BatchDto;
import com.xworkz.module.dto.StudentDto;
import com.xworkz.module.service.admin.batch.BatchService;
import com.xworkz.module.service.admin.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private BatchService batchService;

    @Autowired
    private StudentService studentService;

    @PostMapping("addBatch")
    public ModelAndView addBatch(@Valid @ModelAttribute("batch") BatchDto batchDto, BindingResult bindingResult, ModelAndView modelAndView) {
        System.out.println(batchDto);
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> modelAndView.addObject(fieldError.getField() + "Error", fieldError.getDefaultMessage()));
            modelAndView.setViewName("AddBatch");
            return modelAndView;
        }

        if (batchDto != null) {
            System.out.println(batchDto);
            batchService.validateAndSave(batchDto);
            modelAndView.addObject("success", "Batch Added Successfully");
            modelAndView.setViewName("AdminPage");
        } else {
            System.out.println("Dto is null");
        }
        return modelAndView;
    }

    @GetMapping("registerStudent")
    public String getBatchListStudentReg(HttpSession session) {
        List<BatchDto> batchList = batchService.getBatchList();

        System.out.println("BATCH LIST SIZE = " + batchList.size());
        batchList.forEach(System.out::println);

        session.setAttribute("batchList", batchList);
        //  session.setAttribute("fromBatch", false);
        return "StudentRegForm";
    }

    @GetMapping("batchList")
    public String getBatchList(HttpSession session) {
        List<BatchDto> batchList = batchService.getBatchList();

        System.out.println("BATCH LIST SIZE = " + batchList.size());
        batchList.forEach(System.out::println);

        session.setAttribute("batchList", batchList);
        //  session.setAttribute("fromBatch", false);
        return "BatchList";
    }

    @GetMapping("batchDetails")
    public String getBatchDetails(@RequestParam("batchId") int batchId, HttpSession session) {
        Optional<BatchDto> batchDetails = batchService.getBatchDetails(batchId);
        session.setAttribute("batch", batchDetails.get());
        session.setAttribute("fromBatch", true);
        return "BatchDetails";
    }

    @PostMapping("addStudent")
    public String addStudents(StudentDto studentDto, Model model) {
        if (studentDto != null) {
            studentService.validateAndSaveStudents(studentDto);
            model.addAttribute("success", "Student Registered Successfully");
            return "StudentRegForm";
        }

        model.addAttribute("fail", "Student Not Registered");
        return "StudentRegForm";
    }

    @GetMapping("studentsList")
    public String getStudentsList(HttpSession session) {
        System.out.println("studentsList.....");
        List<StudentDto> studentDtos = studentService.getStudentList();

        System.out.println("BATCH LIST SIZE = " + studentDtos.size());
        studentDtos.forEach(dto ->
                System.out.println(dto.getStudentId() + " - " + dto.getStudentName())
        );


        session.setAttribute("studentList", studentDtos);
        //  session.setAttribute("fromBatch", false);
        return "StudentList";
    }

    @GetMapping("students")
    public String getStudentsByBatchId(@RequestParam("batchId") int batchId, HttpSession session) {
        System.out.println(batchId);
        if (batchId != 0) {
            List<StudentDto> studentDtoList = studentService.getStudentsByBatchId(batchId);
            System.out.println(studentDtoList);
            session.setAttribute("getStudentsByBatchId", studentDtoList);
        }

        return "StudentList";
    }

    @GetMapping("editStudent")
    public String editStudentDetails(@RequestParam("studentId") int studentId, Model model) {
        if (studentId != 0) {
            Optional<StudentDto> studentDto = studentService.editStudent(studentId);
        //    System.out.println(studentDto);
            model.addAttribute("editStudent", studentDto.get());
            return "UpdateStudent";
        }
        return null;
    }

    @PostMapping("updateStudent")
    public String updateStudentDetails(StudentDto studentDto,Model model){
        boolean detailsUpdated=studentService.updateStudent(studentDto);
        if (detailsUpdated){
            model.addAttribute("success","Student Details Updated Successfully");
            return "UpdateStudent";
        }
        model.addAttribute("fail","Failed to update student details");
        return "UpdateStudent";
    }

    @GetMapping("deleteStudent")
    public String deleteStudent(@RequestParam int studentId,Model model) {
        boolean deletedSuccessfully=studentService.deleteStudentById(studentId);
        if (deletedSuccessfully){
            model.addAttribute("success","Student Deleted Successfully");
            return "StudentList";
        }
        model.addAttribute("fail","Student deletion failed");

        return "StudentList";
    }

}
