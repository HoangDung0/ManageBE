package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.WorkingHourDto;
import com.example.capstoneprojectbe.model.WorkingHour;
import com.example.capstoneprojectbe.service.WorkingHourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/workinghour")
public class WorkingHourController {

    private final WorkingHourService workingHourService;

    public WorkingHourController(WorkingHourService workingHourService) {
        this.workingHourService = workingHourService;
    }


    @PostMapping("/create")
    public ResponseEntity createWorkHistory(@RequestBody WorkingHourDto dto) {// lấy dữ liệu tryền vào dto
        if(workingHourService.isExisted(dto.getWorkingHourID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(workingHourService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getWorkScheduleID())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        workingHourService.createWorkingHour(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<WorkingHour> workingHourList = workingHourService.getAllWorkingHour();
        return ResponseEntity.ok().body(workingHourList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody WorkingHourDto dto) {
        workingHourService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        workingHourService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<WorkingHour> workingHourList = workingHourService.getByUserId(id);
        return ResponseEntity.ok().body(workingHourList);
    }

}
