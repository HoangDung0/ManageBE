package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.RewardAndDisciplineDto;
import com.example.capstoneprojectbe.model.RewardAndDiscipline;
import com.example.capstoneprojectbe.service.RewardAndDisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/rewardanddiscipline")
public class RewardAndDisciplineController {
    private final RewardAndDisciplineService rewardAndDisciplineService;


    public RewardAndDisciplineController(RewardAndDisciplineService rewardAndDisciplineService) {
        this.rewardAndDisciplineService = rewardAndDisciplineService;
    }


    @PostMapping("/create")
    public ResponseEntity createRewardAndDiscipline(@RequestBody RewardAndDisciplineDto dto) {// lấy dữ liệu tryền vào dto
        if(rewardAndDisciplineService.isExisted(dto.getRewardAndDisciplineID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        rewardAndDisciplineService.createRewardAndDiscipline(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<RewardAndDiscipline> rewardAndDisciplineList = rewardAndDisciplineService.getAll();
        return ResponseEntity.ok().body(rewardAndDisciplineList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody RewardAndDisciplineDto dto) {
        rewardAndDisciplineService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        rewardAndDisciplineService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<RewardAndDiscipline> rewardAndDisciplineList = rewardAndDisciplineService.getByUserId(id);
        return ResponseEntity.ok().body(rewardAndDisciplineList);
    }
}
