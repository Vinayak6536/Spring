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
import java.io.IOException;
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

    @RequestMapping("returnAddBatch")
    public String returnAddBatch(){
        return "AddBatch";
    }

    @PostMapping("addBatch")
    public ModelAndView addBatch(@Valid @ModelAttribute("batch") BatchDto batchDto, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {
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

    @RequestMapping("backAdminPage")
    public String backAdminPage(){
        return "AdminPage";
    }

    @RequestMapping("adminProfileDetails")
    public String adminProfileDetails(){
        return "AdminProfileDetails";
    }

    @GetMapping("registerStudent")
    public String getBatchListStudentReg(Model model) {
        List<BatchDto> batchList = batchService.getBatchList();

        System.out.println("BATCH LIST SIZE = " + batchList.size());
        batchList.forEach(System.out::println);

        model.addAttribute("batchList", batchList);
        model.addAttribute("fromBatch", false);
        return "StudentRegForm";
    }

    @GetMapping("registerStudentById/{batchId}")
    public String getBatchIdStudentReg(@PathVariable("batchId") int batchId, Model model) {
        Optional<BatchDto> batchList = batchService.getBatchId(batchId);

        model.addAttribute("batch", batchList.get());
        model.addAttribute("fromBatch", true);
        return "StudentRegForm";
    }

    @GetMapping("batchList")
    public String getBatchList(Model model) {
        List<BatchDto> batchList = batchService.getBatchList();

        System.out.println("BATCH LIST SIZE = " + batchList.size());
        batchList.forEach(System.out::println);

        model.addAttribute("batchList", batchList);
        model.addAttribute("isEdit", false);
        return "BatchList";
    }

    @GetMapping("batchDetails")
    public String getBatchDetails(@RequestParam("batchId") int batchId, Model model) {
        Optional<BatchDto> batchDetails = batchService.getBatchDetails(batchId);
        model.addAttribute("batch", batchDetails.get());
        model.addAttribute("fromBatch", true);
        return "BatchDetails";
    }

    @PostMapping("addStudent")
    public String addStudents(StudentDto studentDto, Model model) throws IOException {
        if (studentDto != null) {
            studentService.validateAndSaveStudents(studentDto);
            model.addAttribute("success", "Student Registered Successfully");
           // model.addAttribute("fromBatch", true);

            return "StudentRegForm";
        }

        model.addAttribute("fail", "Student Not Registered");
        return "StudentRegForm";
    }

    @GetMapping("studentsList")
    public String getStudentsList(Model model) {
        System.out.println("studentsList.....");
        List<StudentDto> studentDtos = studentService.getStudentList();

        System.out.println();
        System.out.println("BATCH LIST SIZE = " + studentDtos.size());
        studentDtos.forEach(dto ->
                System.out.println(dto.getStudentId() + " - " + dto.getStudentName() + " " +dto.getImagePath())
        );


        model.addAttribute("studentList", studentDtos);
        model.addAttribute("isEdit", false);

        model.addAttribute("fromBatch", false);
        return "StudentList";
    }

    @GetMapping("students")
    public String getStudentsByBatchId(@RequestParam("batchId") int batchId,Model model) {
        System.out.println(batchId);
        if (batchId != 0) {
            List<StudentDto> studentDtoList = studentService.getStudentsByBatchId(batchId);
            System.out.println(studentDtoList);
            model.addAttribute("getStudentsByBatchId", studentDtoList);
        }

        return "StudentList";
    }

    @GetMapping("editStudent")
    public String editStudentDetails(@RequestParam("studentId") int studentId, Model model) {
        if (studentId != 0) {
            Optional<StudentDto> studentDto = studentService.editStudent(studentId);
        //    System.out.println(studentDto);
            model.addAttribute("profileImage",studentDto.get().getFile());
            model.addAttribute("isEdit",true);
            model.addAttribute("editStudent", studentDto.get());
            return "UpdateStudent";
        }
        return null;
    }

    @PostMapping("updateStudent")
    public String updateStudentDetails(StudentDto studentDto,Model model) throws IOException {
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
