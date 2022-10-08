package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.RegistrationScheduleDto;
import com.example.capstoneprojectbe.dto.WorkScheduleDto;
import com.example.capstoneprojectbe.model.RegistrationSchedule;
import com.example.capstoneprojectbe.model.WorkSchedule;
import com.example.capstoneprojectbe.service.RegistrationScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/registrationschedule")
public class RegistrationScheduleController {

    private final RegistrationScheduleService registrationScheduleService;

    public RegistrationScheduleController(RegistrationScheduleService registrationScheduleService) {
        this.registrationScheduleService = registrationScheduleService;
    }


    @PostMapping("/create")
    public ResponseEntity createRegistrationSchedule(@RequestBody RegistrationScheduleDto dto) {// lấy dữ liệu tryền vào dto
        if(registrationScheduleService.isExisted(dto.getRegistrationScheduleID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        registrationScheduleService.createRegistrationSchedule(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<RegistrationSchedule> registrationSchedulesList = registrationScheduleService.getAll();
        return ResponseEntity.ok().body(registrationSchedulesList);
    }

    @GetMapping("/get-inner")
    private ResponseEntity getRegistrationScheduleInnerUserID(){
        List<RegistrationSchedule> registrationSchedulesList = registrationScheduleService.getRegistrationScheduleInnerUserID();
        return ResponseEntity.ok().body(registrationSchedulesList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody RegistrationScheduleDto dto) {
        registrationScheduleService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        registrationScheduleService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<RegistrationSchedule> registrationScheduleList = registrationScheduleService.getByUserId(id);
        return ResponseEntity.ok().body(registrationScheduleList);
    }
}
