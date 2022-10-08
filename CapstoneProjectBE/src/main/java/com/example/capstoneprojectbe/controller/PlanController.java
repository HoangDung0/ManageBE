package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.PlanDto;
import com.example.capstoneprojectbe.model.Plan;
import com.example.capstoneprojectbe.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/plan")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createPlan(@RequestBody PlanDto dto) {// lấy dữ liệu tryền vào dto
        if(planService.isExisted(dto.getPlanID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
        }
        // tạo annoation//?
        planService.createPlan(dto);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<Plan> planList = planService.getAll();
        return ResponseEntity.ok().body(planList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody PlanDto dto) {
        planService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        planService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<Plan> planList = planService.getByUserId(id);
        return ResponseEntity.ok().body(planList);
    }

    @GetMapping("/get-by-date")
    private ResponseEntity getByDate(@RequestParam String date1, @RequestParam String date2) {
        List<Plan> planList = planService.getPlanByDate(date1, date2);
        return ResponseEntity.ok().body(planList);
    }

}
