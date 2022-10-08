package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.EmployeeAssessmentDto;
import com.example.capstoneprojectbe.model.EmployeeAssessment;
import com.example.capstoneprojectbe.service.EmployeeAssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employeeassessment")
public class EmployeeAssessmentController {
    private final EmployeeAssessmentService employeeAssessmentService;

    public EmployeeAssessmentController(EmployeeAssessmentService employeeAssessmentService) {
        this.employeeAssessmentService = employeeAssessmentService;
    }


    @PostMapping("/create")
    public ResponseEntity createEmployeeAssessment(@RequestBody EmployeeAssessmentDto dto) {// lấy dữ liệu tryền vào dto
        if(employeeAssessmentService.isExisted(dto.getAssessmentID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        employeeAssessmentService.createEmployeeAssessment(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<EmployeeAssessment> employeeAssessmentList = employeeAssessmentService.getAll();
        return ResponseEntity.ok().body(employeeAssessmentList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody EmployeeAssessmentDto dto) {
        employeeAssessmentService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        employeeAssessmentService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<EmployeeAssessment> employeeAssessmentList = employeeAssessmentService.getByUserId(id);
        return ResponseEntity.ok().body(employeeAssessmentList);
    }
}
